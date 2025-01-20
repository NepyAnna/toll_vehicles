package com.sheoanna;

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
        Vehicle bug = new Vehicle("AA1234BB", 2);
        Vehicle truck = new Vehicle("QRT34562UY", 8);

        TollStation bilbao = new TollStation("BTS", "Bilbao");

        bilbao.calculateToll(truck);
        bilbao.calculateToll(bug);

        bilbao.printReport();
    }
}
