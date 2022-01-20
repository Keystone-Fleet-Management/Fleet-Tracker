package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.Jobs;
import com.fleettracker.fleettracker.models.Vehicle;
import com.fleettracker.fleettracker.models.data.DriverRepository;
import com.fleettracker.fleettracker.models.data.JobRepository;
import com.fleettracker.fleettracker.models.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("check-out-vehicle")
    public String displayAddVehicleForm(Model model) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        model.addAttribute(new Vehicle());
        return "check-out-vehicle";
    }

    @GetMapping("vehicle-status")
    public String displayAllVehicleStatus(Model model){
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle-Status";


    }

    @PostMapping("check-out-vehicle")
    public String processCreateJobForm(@ModelAttribute @Valid Vehicle newVehicle, Errors errors){

        vehicleRepository.save(newVehicle);
        return "check-out-vehicle";
    }

}
