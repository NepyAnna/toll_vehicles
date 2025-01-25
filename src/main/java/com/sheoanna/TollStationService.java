package com.sheoanna;

import java.util.List;

import com.sheoanna.vehicles.Vehicle;

public class TollStationService {
    private final TollStation tollStation;

    public TollStationService(String name, String city) {
        this.tollStation = new TollStation(name, city);
    }

    public String getName() {
        return tollStation.getName();
    }

    public String getCity() {
        return tollStation.getCity();
    }

    public float getTotalToll() {
        return tollStation.getTotalToll();
    }

    public List<String> getReports() {
        return tollStation.getReports();
    }

    public void calculateToll(Vehicle vehicle) {
        tollStation.calculateToll(vehicle);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Station: ").append(tollStation.getName())
              .append(" in ").append(tollStation.getCity()).append("\n");
        tollStation.getReports().forEach(report::append);
        report.append("Total toll amount: ").append(tollStation.getTotalToll()).append(" $");
        return report.toString();
    }
}
