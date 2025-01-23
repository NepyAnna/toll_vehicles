package com.sheoanna;

import com.sheoanna.vehicles.Car;
import com.sheoanna.vehicles.Motorcycle;
import com.sheoanna.vehicles.Truck;
import com.sheoanna.vehicles.Vehicle;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Vehicle moto = new Motorcycle("QRT34562UY");
        Vehicle bug = new Car("AA1234BB");
        Vehicle truck = new Truck("LMN789", 8);

        TollStation bilbao = new TollStation("BTS", "Bilbao");

        bilbao.calculateToll(moto);
        bilbao.calculateToll(bug);
        bilbao.calculateToll(truck);

        bilbao.printReport();
      
    }
}
