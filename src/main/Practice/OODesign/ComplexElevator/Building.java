package main.Practice.OODesign.ComplexElevator;

import java.util.*;

public class Building {
    public static void main(String[] args) throws InterruptedException {
        Thread process = new Thread(ControlCenter.getInstance());
        Elevator e1 = new Elevator("E1", new ArrayList<Person>(), 0, 0, Status.STOP, 0);
        Elevator e2 = new Elevator("E2", new ArrayList<Person>(), 0, 0, Status.STOP, 0);
        Elevator e3 = new Elevator("E3", new ArrayList<Person>(), 0, 0, Status.STOP, 0);
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(e1);
        elevators.add(e2);
        elevators.add(e3);
        ControlCenter.getInstance().registerElevators(elevators);
        Thread elevator1 = new Thread(e1);
        Thread elevator2 = new Thread(e2);
        Thread elevator3 = new Thread(e3);
        elevator1.start();
        elevator2.start();
        elevator3.start();
        process.start();
        ControlCenter.getInstance().addRequest(new Request(5, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(6, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(8, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(10, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(14, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(18, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(10, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(12, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(8, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(9, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(11, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(19, 5));
        Thread.sleep(2000L);
        ControlCenter.getInstance().addRequest(new Request(6, 5));
        Thread.sleep(2000L);









    }
}
