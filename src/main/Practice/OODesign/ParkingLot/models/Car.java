package main.Practice.OODesign.ParkingLot.models;

import main.Practice.OODesign.ParkingLot.Color;
import main.Practice.OODesign.ParkingLot.Size;

public class Car extends Vehicle {

    private Size size;

    public Car() {
        super();
        this.size = Size.M;
    }

    public Car(String license, Color color) {
        super(license, color);
        this.size = Size.M;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
