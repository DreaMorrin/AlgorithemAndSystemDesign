package main.Practice.OODesign.ComplexElevator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Elevator implements Runnable {
    private String id;
    private List<Person> passengers;
    private int currFloor;
    private Status status;
    private List<Integer> floors;

    public Elevator (String id, List<Person> passengers, int nextFloor, int currFloor, Status status, int maxWeight) {
        this.id = id;
        this.passengers = passengers;
        this.currFloor = currFloor;
        this.status = status;
        this.floors = new ArrayList<>();
    }

    public void backToGround() {
        currFloor = 0;
    }

    public Status getStatus() {
        return status;
    }

    public void addFloor(int floor) {
        floors.add(floor);
    }

    @Override
    public void run() {
        while (true) {
            try {
                moveNext();
                System.out.println(id + " has moved to floor: " + currFloor);
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveNext() {
        if (!floors.isEmpty()) {
            List<Integer> list = floors.stream().filter(f -> f > currFloor).sorted().collect(Collectors.toList());
            if (!list.isEmpty()) {
                currFloor = list.get(0);
                for (int i = 0; i < floors.size(); i++) {
                    if (floors.get(i) == currFloor) {
                        floors.remove(i);
                    }
                }
                status = Status.UP;
            }
            list = floors.stream().filter(f -> f < currFloor).sorted().collect(Collectors.toList());
            if (!list.isEmpty()) {
                currFloor = list.get(list.size() - 1);
                for (int i = 0; i < floors.size(); i++) {
                    if (floors.get(i) == currFloor) {
                        floors.remove(i);
                    }
                }
                status = Status.DOWN;
            }
        } else {
            backToGround();
            status = Status.STOP;
            System.out.println("Idle");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }

    public int getCurrFloor() {
        return currFloor;
    }
}
