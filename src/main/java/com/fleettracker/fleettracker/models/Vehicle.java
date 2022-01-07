package com.fleettracker.fleettracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle{
    @GeneratedValue @Id
    private int vehicleId;
    private String vehiclePlate;
    private int driverId;
    private int mileage;
    private boolean isCheckedOut;
    private boolean needsRepair;
    private String detailedStatus;

    public Vehicle(){}

    public Vehicle(String vehiclePlate, int mileage, boolean needsRepair) {
        this.vehiclePlate = vehiclePlate;
        this.mileage = mileage;
        this.isCheckedOut = false;
        this.needsRepair = needsRepair;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
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
