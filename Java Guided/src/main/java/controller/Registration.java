package controller;

import model.AbstractBike;

public class Registration {
    public static void allocatingBikeSerialNumber(AbstractBike bike) {
        System.out.println("Registering " + bike.getClass().getSimpleName() + " bike " + " \nserial number " + bike.getSerial()
        + " \nColor " + bike.getColor() + " \nPrice " + bike.getPrice());
    }
}
