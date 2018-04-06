package main.Practice.OODesign.ParkingLot.models;

import main.Practice.OODesign.ParkingLot.Color;
import main.Practice.OODesign.ParkingLot.Size;

public class Truck extends Vehicle {
    private Size size;

    public Truck() {
        super();
        this.size = Size.L;
    }

    public Truck(String license, Color color) {
        super(license, color);
        this.size = Size.L;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
