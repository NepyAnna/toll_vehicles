package com.sheoanna;

import java.util.ArrayList;
import java.util.List;

import com.sheoanna.vehicles.Vehicle;

public class TollStation {
    private String name;
    private String city;
    private float totalToll;
    private List<String> reports;

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalToll = 0;
        this.reports = new ArrayList<>();
    }

    public void calculateToll(Vehicle vehicle) {
        float toll = vehicle.calculateToll();
        totalToll += toll;
        addReport(vehicle, toll);
    }

    private void addReport(Vehicle vehicle, float toll) {
        String report = "";
        report += "\n" + "Vehicle with License Number: " + vehicle.getLicenseNumber();
        report += "\n" + "Toll Amount: " + toll + " $\n";
        this.reports.add(report);
    }

    public void printReport() {
        System.out.println("\nStation: " + this.name + " in " + this.city + ":");
        reports.forEach(System.out::println);
        System.out.println("Total toll amount: " + this.totalToll + " $\n");
    }
}