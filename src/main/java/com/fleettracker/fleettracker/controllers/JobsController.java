package com.fleettracker.fleettracker.controllers;

import com.fleettracker.fleettracker.models.Jobs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class JobsController {



    @GetMapping("createjob")
    public String displayCreateJobForm(Model model) {
        model.addAttribute(new Jobs());
        return "createjob";
    }

    @PostMapping("createjob")
    public String processCreateJobForm(@ModelAttribute @Valid Jobs newJob, Errors errors){
        if (errors.hasErrors()) {
            return "createjob";
        }
        return "redirect:";


    }

}
