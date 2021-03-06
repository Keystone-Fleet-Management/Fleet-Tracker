package com.fleettracker.fleettracker.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private int userId;

    @NotNull @Size(min=3)
    private String name;

    @NotNull @Size(min=3)
    private String username;

    @NotNull @Size(min=6)
    private String password;

    public User() {}

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
