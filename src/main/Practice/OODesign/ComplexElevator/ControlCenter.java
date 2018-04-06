package main.Practice.OODesign.ComplexElevator;

import java.util.*;

public class ControlCenter implements Runnable {
    private static ControlCenter instance = null;
    private Queue<Request> eventingQueue;
    private Map<String, Elevator> elevatorMap;
    private ControlCenter() {
        this.eventingQueue = new LinkedList<>();
        this.elevatorMap = new HashMap<>();
    }

    public static ControlCenter getInstance() {
        if (instance == null) {
            synchronized (ControlCenter.class) {
                if (instance == null) {
                    instance = new ControlCenter();
                }
            }
        }
        return instance;
    }

    public void addRequest(Request request) {
        eventingQueue.offer(request);
    }

    @Override
    public void run() {
        while (true) {
            processingNextRequest();
        }
    }

    private void processingNextRequest() {
        while (!eventingQueue.isEmpty()) {
            Request request = eventingQueue.poll();
            PriorityQueue<Elevator> pq = new PriorityQueue<Elevator>((e1, e2) -> (e1.getCurrFloor() - request.getTo()) - (e2.getCurrFloor() - request.getTo()));
            for (Elevator elevator : elevatorMap.values()) {
                pq.add(elevator);
            }
            if (pq.size() > 0) {
                System.out.println("Precessing request to floor " + request.getTo() + " with Elevator " + pq.peek().getId() + ", currentFloor is: " + pq.peek().getCurrFloor());
                dispatchToElevator(request.getTo(), pq.poll().getId());
            }
        }
    }

    private void dispatchToElevator(int floor, String elevatorId) {
        elevatorMap.get(elevatorId).addFloor(floor);
    }

    public void registerElevators(List<Elevator> elevators) {
        for (Elevator elevator : elevators) {
            elevatorMap.put(elevator.getId(), elevator);
        }
    }
}
