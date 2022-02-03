package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.*;
import com.fleettracker.fleettracker.models.data.DriverRepository;
import com.fleettracker.fleettracker.models.data.JobRepository;
import com.fleettracker.fleettracker.models.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
public class VehicleController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("add-vehicle")
    public String displayAddVehicleForm(Model model) {
        model.addAttribute(new Vehicle());
        return "add-vehicle";
    }

    @GetMapping("check-out-vehicle")
    public String displayCheckoutVehicleForm(Model model, HttpSession session) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        User currentUser = driverRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if(driverRepository.findById(currentUser.getUserID()).isPresent()) {
            Driver currentDriver = driverRepository.findById(currentUser.getUserID()).get();
            model.addAttribute("currentDriver", currentDriver);
        } else {model.addAttribute("currentDriver", new Driver("No Driver", "user", "password"));}

        return "check-out-vehicle";
    }

    @GetMapping("check-in-vehicle")
    public String displayCheckInVehicleForm(Model model) {
        User currentUser = driverRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Driver currentDriver;
        if(driverRepository.findById(currentUser.getUserID()).isPresent()) {
            currentDriver = driverRepository.findById(currentUser.getUserID()).get();
            model.addAttribute("currentDriver", currentDriver);
        }else{
            currentDriver = new Driver("No Driver", "user", "password");
            model.addAttribute("currentDriver", currentDriver);
        }

        if (currentDriver.getVehicle() != null){
            Vehicle currentVehicle = currentDriver.getVehicle();
            model.addAttribute("vehicle", currentVehicle);
            String checkedOutName = "You currently have the " + currentDriver.getVehicle().getVehicleName() + " checked out.";
            model.addAttribute("checkedOut", checkedOutName);
        } else{
            String checkedOutName = "You do not currently have a vehicle checked out.";
            model.addAttribute("checkedOut", checkedOutName);
            model.addAttribute("vehicle", new Vehicle("NONE ", "NONE", 0, false));
        }
        return "check-in-vehicle";
    }

    @GetMapping("vehicle-status")
    public String displayAllVehicleStatus(@RequestParam(required = false) @Valid Integer vehicleId, Model model){
        if(vehicleRepository.count()>0) {
            Iterable<Vehicle> vehicles = vehicleRepository.findAll();
            Optional<Vehicle> optVehicle;
            model.addAttribute("vehicles", vehicles);
            if (vehicleId != null) {
                optVehicle = vehicleRepository.findById(vehicleId);
            } else {
                optVehicle = vehicleRepository.findById(1);
            }
            model.addAttribute("selectedVehicle", optVehicle.get());
        } else {
            model.addAttribute("selectedVehicle", new Vehicle("NONE ", "NONE", 0, false));
        }
        return "vehicle-Status";

    }

    @PostMapping("add-vehicle")
    public String processAddVehicleForm(@ModelAttribute @Valid Vehicle newVehicle, Errors errors){
        vehicleRepository.save(newVehicle);
        return "redirect:/add-vehicle";
    }

    @PostMapping("check-out-vehicle")
    public String checkoutVehicle(@RequestParam int vehicleId){
        Optional<Vehicle> optVehicle = vehicleRepository.findById(vehicleId);
        Driver currentDriver = driverRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        if(optVehicle.isPresent()){
            Vehicle selectedVehicle = (Vehicle) optVehicle.get();
            currentDriver.setVehicle(selectedVehicle);
            selectedVehicle.setDriver(currentDriver);
            selectedVehicle.setCheckedOut(true);

            //Moves current status to previous status. Sets current status to checked out message. If previousStatus list is longer than 10 items it deletes oldest item.
            selectedVehicle.addPreviousStatus(selectedVehicle.getCurrentStatus());
            selectedVehicle.setCurrentStatus(new Status("Checked out by " + currentDriver.getName() + "."));
            if(selectedVehicle.getPreviousStatus().size() > 10){
                selectedVehicle.deletePreviousStatus(9);
            }

            driverRepository.save(currentDriver);
            vehicleRepository.save(selectedVehicle);
        }
        return "check-out-vehicle";
    }

    @PostMapping("check-in-vehicle")
    public String checkInVehicle(@RequestParam @Valid int mileage, @RequestParam(required = false) boolean repair_status, @RequestParam String status, @RequestParam int vehicleId){
        Vehicle currentVehicle = vehicleRepository.findById(vehicleId).get();
        Driver currentDriver = driverRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        boolean repairStatus = repair_status;
        currentVehicle.setMileage(mileage);
        currentVehicle.setNeedsRepair(repairStatus);
        currentVehicle.setCheckedOut(false);
        currentVehicle.addPreviousStatus(currentVehicle.getCurrentStatus());
        currentVehicle.setCurrentStatus(new Status("Checked in by " + currentDriver.getName() + "."));

        if(status !="") {
            currentVehicle.addPreviousStatus(currentVehicle.getCurrentStatus());
            currentVehicle.setCurrentStatus(new Status(status));
        }
        if(currentVehicle.getPreviousStatus().size() > 10){
            currentVehicle.deletePreviousStatus(9);
        }

        currentVehicle.removeDriver();
        currentDriver.removeVehicle();
        vehicleRepository.save(currentVehicle);
        driverRepository.save(currentDriver);
        return "redirect:/check-in-vehicle";
    }
}
