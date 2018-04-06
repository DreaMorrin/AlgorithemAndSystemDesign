package main.Practice.OODesign.ParkingLot.models;

import main.Practice.OODesign.ParkingLot.Color;
import main.Practice.OODesign.ParkingLot.Size;

public class MotorCycle extends Vehicle {
    Size size;

    public MotorCycle() {
        super();
        this.size = Size.S;
    }

    public MotorCycle(String license, Color color) {
        super(license, color);
        this.size = Size.S;
    }
}
