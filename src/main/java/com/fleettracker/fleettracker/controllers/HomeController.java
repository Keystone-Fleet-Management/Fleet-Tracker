package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.Driver;
import com.fleettracker.fleettracker.models.User;
import com.fleettracker.fleettracker.models.data.DriverRepository;
import com.fleettracker.fleettracker.models.data.JobRepository;
import com.fleettracker.fleettracker.models.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("home")
    public String loginTrack(@RequestParam String username){

        return "home";
    }

}
