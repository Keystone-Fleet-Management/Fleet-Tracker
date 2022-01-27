package com.fleettracker.fleettracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle{
    @GeneratedValue @Id
    private int vehicleId;
    private String vehicleName;
    private String vehiclePlate;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private int mileage;
    private boolean isCheckedOut;
    private boolean needsRepair;
    private String detailedStatus;

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

    public String getDetailedStatus() {
        return detailedStatus;
    }

    public void setDetailedStatus(String detailedStatus) {
        this.detailedStatus = detailedStatus;
    }
}
