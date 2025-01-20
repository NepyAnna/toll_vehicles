package com.sheoanna;

public class Vehicle {
    private String licenseNumber;
    private int axlesNumber;

    public Vehicle(String licenseNumber,int axlesNumber) {
        this.licenseNumber = licenseNumber;
        this.axlesNumber = axlesNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getAxlesNumber() {
        return axlesNumber;
    } 
}
