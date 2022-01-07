package com.fleettracker.fleettracker.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Driver extends User{
    @OneToOne
    private int vehicleId;
    @OneToOne
    private int jobId;

    private String location;
    private boolean onJob;

    public Driver(){}

    public Driver(String name, String username, String password) {
        super(name, username, password);
        this.onJob = false;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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
}
