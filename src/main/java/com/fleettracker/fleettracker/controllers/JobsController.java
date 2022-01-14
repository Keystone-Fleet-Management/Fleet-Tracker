package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.Jobs;
import com.fleettracker.fleettracker.models.data.DriverRepository;
import com.fleettracker.fleettracker.models.data.JobRepository;
import com.fleettracker.fleettracker.models.data.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class JobsController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;


    @GetMapping("createjob")
    public String displayCreateJobForm(Model model) {
        model.addAttribute(new Jobs());
        return "createjob";
    }

    @PostMapping("createjob")
    public String processCreateJobForm(@ModelAttribute @Valid Jobs newJob, Errors errors){
        newJob.setDateCreated(new Date(System.currentTimeMillis()));
        jobRepository.save(newJob);
        return "redirect:";


    }

}
