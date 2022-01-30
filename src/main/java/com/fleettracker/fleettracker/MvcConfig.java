package com.fleettracker.fleettracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/goodbye").setViewName("goodbye");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/createjob").setViewName("createjob");
        registry.addViewController("/landingpage").setViewName("landingpage");
        registry.addViewController("/check-out-vehicle").setViewName("check-out-vehicle");
        registry.addViewController("/check-in-vehicle").setViewName("check-in-vehicle");
        registry.addViewController("/jobstatus").setViewName("jobstatus");
        registry.addViewController("/repair-log").setViewName("repair-log");
        registry.addViewController("/add-vehicle").setViewName("vehicle-status");
        registry.addViewController("/create-user").setViewName("create-user");
        registry.addViewController("/vehicle-status").setViewName("vehicle-status");
    }

}