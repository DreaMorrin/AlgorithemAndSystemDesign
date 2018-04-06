package main.Practice.OODesign.ParkingLot.models;

import main.Practice.OODesign.ParkingLot.Color;
import main.Practice.OODesign.ParkingLot.Size;

public class Bus extends Vehicle {
    Size size;

    public Bus() {
        super();
        this.size = Size.S;
    }

    public Bus(String license, Color color) {
        super(license, color);
        this.size = Size.S;
    }
}
