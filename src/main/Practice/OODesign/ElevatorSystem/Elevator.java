package main.Practice.OODesign.ElevatorSystem;

public class Elevator {
    public static Elevator instance = null;
    private int currentFloor;

    private Elevator() {

    }

    public static Elevator getInstance() {
        if (instance == null) {
            synchronized (Elevator.class) {
                if (instance == null) {
                    instance = new Elevator();
                }
            }
        }
        return instance;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void moveToTargetFloor(int toFloor) {
        currentFloor = toFloor;
    }
}
