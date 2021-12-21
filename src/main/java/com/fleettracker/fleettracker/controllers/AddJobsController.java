package com.fleettracker.fleettracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddJobsController {

    @GetMapping
    public String landingpage() {
        return "landingpage";
    }
}
