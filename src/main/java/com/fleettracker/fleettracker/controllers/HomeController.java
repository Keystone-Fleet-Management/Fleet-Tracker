package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.Driver;
import com.fleettracker.fleettracker.models.Jobs;
import com.fleettracker.fleettracker.models.User;
import com.fleettracker.fleettracker.models.Vehicle;
import com.fleettracker.fleettracker.models.data.DriverRepository;
import com.fleettracker.fleettracker.models.data.JobRepository;
import com.fleettracker.fleettracker.models.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("")
    public String rebuildDatabase(@RequestParam boolean rebuild){
        if(jobRepository.findById(1).isEmpty()) {
            for (int i = 0; i < 10; i++) {
                jobRepository.save(new Jobs("Test Job " + String.valueOf(i), "123 Fake Street, Fake City, FK 11111", "123 Test Ave., Test City, TS 11111","555-555-5555"));
            }
        }
        if(vehicleRepository.findById(1).isEmpty()) {
            for (int i = 0; i < 10; i++) {
                vehicleRepository.save(new Vehicle("Test Vehicle " + String.valueOf(i), "TEST000" + String.valueOf(i), 1000, false));
            }
        }
        if(driverRepository.findById(1).isEmpty()) {
            driverRepository.save(new Driver("Test Driver", "user", "password"));
        }
        return "home";
    }

}
