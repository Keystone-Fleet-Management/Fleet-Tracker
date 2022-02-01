package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.Driver;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import javax.validation.Valid;
import java.sql.Time;
import java.util.ArrayList;
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

    @GetMapping("jobstatus")
    public String displayJobStatus(Model model){
        Iterable<Jobs> allJobs = jobRepository.findAll();
        ArrayList<Jobs> availableJobs = new ArrayList<>();
        ArrayList<Jobs> activeJobs = new ArrayList<>();
        ArrayList<Jobs> completedJobs = new ArrayList<>();

        for(Jobs job : allJobs){
            if(job.jobId == 0) {
                assert true;
            } else if (job.isCompleted()) {
                    completedJobs.add(job);
                } else if (job.isActive()) {
                    activeJobs.add(job);
                } else {
                    availableJobs.add(job);
                }
            }


        model.addAttribute("activeJobs", activeJobs);
        model.addAttribute("availableJobs", availableJobs);
        model.addAttribute("completedJobs", completedJobs);
        return "jobstatus";
    }

    @PostMapping("createjob")
    public String processCreateJobForm(@ModelAttribute @Valid Jobs newJob, Errors errors){
        newJob.setDateCreated(new Date(System.currentTimeMillis()));
        jobRepository.save(newJob);
        return "createjob";
    }

    @PostMapping("jobstatus")
    public String processAcceptJob(@RequestParam int jobId){
        Driver currentDriver = driverRepository.findById(1).get();
        Jobs selectedJob = jobRepository.findById(jobId).get();

        if(selectedJob.isActive()){
            selectedJob.setCompleted(true);
            selectedJob.setActive(false);
            selectedJob.setEndTime(new Time(System.currentTimeMillis()));
            currentDriver.setJob(null);
            currentDriver.setOnJob(false);
            driverRepository.save(currentDriver);
            jobRepository.save(selectedJob);
            return "redirect:/jobstatus";
        }

        if(currentDriver.isOnJob()){
            return "redirect:/jobstatus";
        } else {
            currentDriver.setJob(selectedJob);
            currentDriver.setOnJob(true);
            selectedJob.setDriver(currentDriver);
            selectedJob.setActive(true);
            selectedJob.setStartTime(new Time(System.currentTimeMillis()));
            driverRepository.save(currentDriver);
            jobRepository.save(selectedJob);
        }
        return "redirect:/jobstatus";
    }


}
