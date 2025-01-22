package com.sheoanna.vehicles;

public class Vehicle {
    private String licenseNumber;
    private int axlesNumber;

    public Vehicle(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.axlesNumber = 1;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setAxlesNumber(int axlesNumber) {
        this.axlesNumber = axlesNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getAxlesNumber() {
        return axlesNumber;
    }

}
