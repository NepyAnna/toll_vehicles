package com.sheoanna.vehicles;

public class Truck implements Vehicle {
    private String licenseNumber;
    private int axlesNumber;

    public Truck(String licenseNumber, int axlesNumber) {
        if (axlesNumber < 6) {
            throw new IllegalArgumentException("A truck must have at least 6 axles.");
        }
        this.licenseNumber = licenseNumber;
        this.axlesNumber = axlesNumber;
    }

    @Override
    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public float calculateToll() {
        return axlesNumber * 50;
    }
}

