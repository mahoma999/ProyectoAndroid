package com.example.uberclon.models;

public class Driver {
    String id;
    String name;
    String email;
    String password;
    String vehicleBrand;
    String vehiclePlate;

    public Driver(String id, String name, String email, String password, String vehicleBrand, String vehiclePlate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.vehicleBrand = vehicleBrand;
        this.vehiclePlate = vehiclePlate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }
}
