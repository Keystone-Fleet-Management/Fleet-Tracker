package com.fleettracker.fleettracker.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Jobs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer jobId;

    @NotBlank @NotNull @Size(min=4, max = 50)
    private String clientName;

    @NotBlank @NotNull @Size(min=4, max = 100)
    private String startLocation;

    @NotBlank @NotNull @Size(min=4, max = 100)
    private String endLocation;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="driver_id")
    private Driver driver;

    private String dateCreated;
    private String startTime;
    private String endTime;
    private boolean isActive;
    private boolean isCompleted;
    @Transient
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy | hh:mm:ssa");
    @Transient
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ssa");

    public Jobs(){}

    public Jobs(String clientName, String startLocation, String endLocation, String phoneNumber) {
        this.clientName = clientName;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateFormat.format(new Date(System.currentTimeMillis()));
        this.isActive = false;
        this.isCompleted = false;
    }

    public Integer getJobID() {
        return jobId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateFormat.format(dateCreated);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = timeFormat.format(startTime);
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = timeFormat.format(endTime);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
