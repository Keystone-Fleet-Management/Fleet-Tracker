package com.fleettracker.fleettracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle{
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private int vehicleId;
    private String vehicleName;
    private String vehiclePlate;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private int mileage;
    private boolean isCheckedOut;
    private boolean needsRepair;
    @OneToOne(cascade = CascadeType.ALL)
    private Status currentStatus;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Status> previousStatus= new ArrayList<>();

    public Vehicle(){}

    public Vehicle(String vehicleName, String vehiclePlate, int mileage, boolean needsRepair) {
        this.vehicleName = vehicleName;
        this.vehiclePlate = vehiclePlate;
        this.mileage = mileage;
        this.isCheckedOut = false;
        this.needsRepair = needsRepair;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public boolean isNeedsRepair() {
        return needsRepair;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<Status> getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(ArrayList<Status> previousStatus) {
        this.previousStatus = previousStatus;
    }

    public void addPreviousStatus(Status status) {
        this.previousStatus.add(status);
    }

    public void deletePreviousStatus(int index){
        this.previousStatus.remove(index);
    }

    public void removeDriver(){
        this.driver = null;
    }
}
