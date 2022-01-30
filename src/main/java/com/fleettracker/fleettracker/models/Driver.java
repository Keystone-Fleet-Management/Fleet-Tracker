package com.fleettracker.fleettracker.models;

import com.fleettracker.fleettracker.models.data.VehicleRepository;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver extends User{


    @OneToOne
    @JoinColumn(name ="vehicle_id")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name ="job_id")
    private Jobs job;

    private String location;
    private boolean onJob;

    public Driver(){}

    public Driver(String name, String username, String password) {
        super(name, username, password);
        this.onJob = false;

    }

     public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOnJob() {
        return onJob;
    }

    public void setOnJob(boolean onJob) {
        this.onJob = onJob;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public void removeVehicle(){this.vehicle = null;}

    public void removeJob(){this.job = null;}
}
