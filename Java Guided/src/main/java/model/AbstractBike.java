package model;
import main.FrameColors;

public abstract class AbstractBike implements PriceInterface, BikeInterface {
    private FrameColors color;
    private String serial;

    public AbstractBike(FrameColors color) {
        this.color = color;
    }

    public FrameColors getColor() {
        return color;
    }

    public abstract double getPrice();

    public abstract int getStart();

    public abstract String getPrefix();

    public abstract String getWheelType();

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String getSerial() {
        return serial;
    }

    public void paintFrame(FrameColors color) {
        this.color = color;
    }

    @Override
    public void airTires() {
        System.out.println("We air our bike tires to a consistent 32 psi.");
        System.out.println("We test each tire prior to sale for proper air pressure.");
    }

    @Override
    public void washFrame() {
        System.out.println("We Wash our bike frames with non abrasive detergent.");
        System.out.println("We rinse and dry our bike frames for a prestine shine.");
    }

    @Override
    public void testRide() {
        System.out.println("We test ride our bikes to ensure a proper ride.");
    }

    @Override
    public String toString() {
        String price = String.format("%9s", "$" + getPrice());
        return getClass().getSimpleName() + price + " Model# " + getPrefix() + " " +
                getColor() + " Frame with serial# " + getSerial();
    }
}
