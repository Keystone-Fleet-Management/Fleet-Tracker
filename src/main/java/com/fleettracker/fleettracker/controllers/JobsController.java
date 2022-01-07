package com.fleettracker.fleettracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsController {

    @GetMapping
    public String home() {
        return "home";
    }
}
