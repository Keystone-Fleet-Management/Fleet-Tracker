package com.fleettracker.fleettracker.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private Date dateAdded;
    private String statusText = "";
    private boolean isHidden;
    private boolean isRead;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    public Status(){}

    public Status(String statusText){
        this.statusText = statusText;
        this.dateAdded = new Date(System.currentTimeMillis());
        this.isHidden = false;
        this.isRead = false;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
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
