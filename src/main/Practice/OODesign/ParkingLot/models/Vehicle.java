package main.Practice.OODesign.ParkingLot.models;

import main.Practice.OODesign.ParkingLot.Color;

public abstract class Vehicle {
    private String license;
    private Color color;

    public Vehicle() {}

    public Vehicle(String license, Color color) {
        this.license = license;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
