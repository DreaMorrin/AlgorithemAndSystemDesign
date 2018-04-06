package main.Practice.OODesign.ParkingLot;

import main.Practice.OODesign.ParkingLot.models.Vehicle;

public class Spot {
    private long id;
    private Size size;

    private Vehicle vehicle;

    public Spot (long id, Size size) {
        this.id = id;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
