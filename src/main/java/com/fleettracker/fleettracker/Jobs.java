//package com.fleettracker.fleettracker;
//
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.sql.Time;
//import java.util.Date;
//
//@Entity
//public class Jobs {
//    @Id @GeneratedValue
//    private Integer jobID;
//
//    @NotBlank @NotNull @Size(min=5, max = 50)
//    private String clientName;
//
//    @NotBlank @NotNull @Size(min=5, max = 100)
//    private String startLocation;
//
//    @NotBlank @NotNull @Size(min=5, max = 100)
//    private String endLocation;
//
//    private Date dateCreated;
//    private Time startTime;
//    private Time endTime;
//    private boolean isCompleted;
//
//    public Jobs(String clientName, String startLocation, String endLocation, Date dateCreated) {
//        this.clientName = clientName;
//        this.startLocation = startLocation;
//        this.endLocation = endLocation;
//        this.dateCreated = new Date();
//        this.isCompleted = false;
//    }
//
//    public Jobs(){}
//
//    public Integer getJobID() {
//        return jobID;
//    }
//
//    public String getClientName() {
//        return clientName;
//    }
//
//    public void setClientName(String clientName) {
//        this.clientName = clientName;
//    }
//
//    public String getStartLocation() {
//        return startLocation;
//    }
//
//    public void setStartLocation(String startLocation) {
//        this.startLocation = startLocation;
//    }
//
//    public String getEndLocation() {
//        return endLocation;
//    }
//
//    public void setEndLocation(String endLocation) {
//        this.endLocation = endLocation;
//    }
//
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public Time getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(Time startTime) {
//        this.startTime = startTime;
//    }
//
//    public Time getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(Time endTime) {
//        this.endTime = endTime;
//    }
//
//    public boolean isCompleted() {
//        return isCompleted;
//    }
//
//    public void setCompleted(boolean completed) {
//        isCompleted = completed;
//    }
//}
