package main;

import controller.InventoryGenerator;
import controller.PrepSale;
import controller.SerialNumberGenerator;
import model.*;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
//        testModel();
//        testingSerialNumberGen();
//        Touring bike = new Touring();
//        System.out.println(bike);
//        testCustomOptions();
//        testPrepForSale();
        orderItems();
//        testInventory();
//        testReceipt();
    }

    public static void orderItems() {
        SampleOrder order = new SampleOrder();
        order.welcomeMessage();
    }

    public static void testReceipt() {
        ArrayList<AbstractBike> bike = new ArrayList<>();
        InventoryGenerator gen = new InventoryGenerator();
        bike.add(gen.getCrossCountryList().get(0));
        bike.add(gen.getDownhillList().get(0));
        AbstractBike custom = gen.getVintageList().get(0);
        custom = new LeatherSeatOption(custom);
        bike.add(custom);

        ArrayList<Accessories> accessories = new ArrayList<>();
        accessories.add(0, new Accessories("Helmet", 29.99));

        new SampleReceipt(bike, accessories);
    }

    public static void testInventory() {
        InventoryGenerator inventory = new InventoryGenerator();
        for(Touring bike : inventory.getTouringList()) {
            System.out.println(bike.getSerial());
        }
    }

    public static void testPrepForSale() {
        PrepSale mySale = new PrepSale();
        InventoryGenerator gen = new InventoryGenerator();
        Downhill downhill = gen.getDownhillList().get(1);
        mySale.prepareForSale(downhill);
        Touring touring = gen.getTouringList().get(1);
        mySale.prepareForSale(touring);
//        System.out.println(me.getSerial());

    }

    public static void testCustomOptions() {
        AbstractBike vintage = new Vintage();
        System.out.println(vintage);
        System.out.println();
        LeatherSeatOption option1 = new LeatherSeatOption(vintage);
        System.out.println(option1.getOptionName());
        System.out.println(option1.getOptionAmount());
        GoldFrameOption option2 = new GoldFrameOption(vintage);
        System.out.println(option2);
    }

    private static void testModel() {
        Touring bike = new Touring();
        System.out.println(bike.getPrefix());
        System.out.println(bike.getColor());
        System.out.println(bike.getWheelType());
        bike.paintFrame(FrameColors.GREEN);
        System.out.println(bike.getColor());
    }

    public static void testingSerialNumberGen() {
        Downhill bike = new Downhill();
        SerialNumberGenerator generator = SerialNumberGenerator.getInstance();
        generator.startGeneration(bike.getPrefix(), bike.getStart());
        bike.setSerial(generator.getNextSerial());
        System.out.println(bike.getSerial());

        System.out.println("Next Serial in line is " + generator.getNextSerial());
        System.out.println("Next Serial in line is " + generator.getNextSerial());
        System.out.println("Next Serial in line is " + generator.getNextSerial());
        System.out.println("Next Serial in line is " + generator.getNextSerial());
        System.out.println("Next Serial in line is " + generator.getNextSerial());

        System.out.println(bike.getPrefix() + " from above " + generator.getRecentNumber());

        Vintage oldBike = new Vintage();


        SerialNumberGenerator myGen = SerialNumberGenerator.getInstance();
        myGen.startGeneration(oldBike.getPrefix(), oldBike.getStart());
        System.out.println("Vintage Next Serial in line is " + myGen.getNextSerial());
        System.out.println("Vintage Next Serial in line is " + myGen.getNextSerial());
        System.out.println("Vintage Next Serial in line is " + myGen.getNextSerial());

        System.out.println("Next Serial in line is " + generator.getNextSerial());
        System.out.println("Next Serial in line is " + generator.getNextSerial());
    }
}
