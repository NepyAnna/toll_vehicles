package com.sheoanna.vehicles;

public class Car implements Vehicle {
    private String licenseNumber;

    public Car(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public float calculateToll() {
        return 100;
    }
}
