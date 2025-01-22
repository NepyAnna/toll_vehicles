package com.sheoanna.vehicles;

public class Truck implements Vehicle {
    private String licenseNumber;
    private int axlesNumber;

    public Truck(String licenseNumber, int axlesNumber) {
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

