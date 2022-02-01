package com.fleettracker.fleettracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String dateAdded;
    private String statusText = "";
    private boolean isHidden;
    private boolean isRead;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @Transient
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy | hh:mm:ssa");

    public Status(){}

    public Status(String statusText){
        this.statusText = statusText;
        this.dateAdded = dateFormat.format(new Date(System.currentTimeMillis()));
        this.isHidden = false;
        this.isRead = false;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateFormat.format(dateAdded);
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
