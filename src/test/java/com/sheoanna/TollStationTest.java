package com.sheoanna;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheoanna.vehicles.Car;
import com.sheoanna.vehicles.Motorcycle;
import com.sheoanna.vehicles.Truck;
import com.sheoanna.vehicles.Vehicle;

public class TollStationTest {
    private TollStation tollStation;
    private Vehicle car;
    private Vehicle moto;
    private Vehicle truck;

    @BeforeEach
    public void setUp() {
        tollStation = new TollStation("BTS", "BILBAO");
        car = new Car("AA1234BB");
        moto = new Motorcycle("XYZ456");
        truck = new Truck("LMN789", 8);
    }

    @Test
    void testCalculateTollForCar() {
        tollStation.calculateToll(car);

        assertEquals(100, tollStation.getTotalToll());
    }

    @Test
    public void testCalculateTollForMotorcycle() {
        tollStation.calculateToll(moto);

        assertEquals(50, tollStation.getTotalToll());
    }

    @Test
    public void testCalculateTollForTruck() {
        tollStation.calculateToll(truck);

        assertEquals(400, tollStation.getTotalToll());
    }

    @Test
    public void testPrintReport() {
        // Redirect System.out to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            tollStation.calculateToll(car);
            tollStation.calculateToll(moto);
            tollStation.calculateToll(truck);
            tollStation.printReport();

            String output = outputStream.toString();
            assertTrue(output.contains("Vehicle with License Number: AA1234BB"));
            assertTrue(output.contains("Vehicle with License Number: XYZ456"));
            assertTrue(output.contains("Vehicle with License Number: LMN789"));
            assertTrue(output.contains("Toll Amount: 100.0 $"));
            assertTrue(output.contains("Toll Amount: 50.0 $"));
            assertTrue(output.contains("Toll Amount: 400.0 $"));
            assertTrue(output.contains("Total toll amount: 550.0 $"));
        } finally {
            System.setOut(originalOut);
        }
    }
}
