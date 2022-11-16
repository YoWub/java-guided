package controller;

import model.AbstractBike;
import model.BikeInterface;

public class PrepSale {
    public void prepareForSale(BikeInterface bike) {
        Registration.allocatingBikeSerialNumber((AbstractBike) bike);
        System.out.println();
        Documentation.printBrochure();
        System.out.println();
        bike.airTires();
        bike.testRide();
        bike.washFrame();
        System.out.println();
    }
}
