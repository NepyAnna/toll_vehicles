package com.sheoanna;

import java.util.List;

public class TollStation {
    private String name;
    private String city;
    private float totalToll;
    private float tollRate;
    private List<String> reports;

    public TollStation(String name, String city){
        this.name = name;
        this.city = city;
        this.totalToll = 0;
        this.tollRate = 50;  
    }

    public void calculateToll(Vehicle vesicle) {
        float toll = vesicle.getAxlesNumber() * this.tollRate;
    }

    public void addRepport(Vehicle vesicle){
        String report = "";


        report += "Vehicles" + vesicle.getLicenseNumber() + "\n";
        report += vesicle.getAxlesNumber();

    }
}
