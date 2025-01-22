package com.sheoanna.vehicles;

public class Motorcycle implements Vehicle {
    private String licenseNumber;

    public Motorcycle(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public float calculateToll() {
        return 50;
    }
}
