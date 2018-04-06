package main.Practice.OODesign.ElevatorSystem;

import java.util.LinkedList;
import java.util.Queue;

public class Controller implements Runnable {
    public static Controller instance = null;
    private Queue<Request> queue;

    private Controller() {
        this.queue = new LinkedList<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            synchronized (Controller.class) {
                if (instance == null) {
                    instance = new Controller();
                }
            }
        }
        return instance;
    }


    @Override
    public void run() {
        while (true) {
            processRequest();
        }
    }

    private void processRequest() {
        Request req = queue.poll();
        Elevator.getInstance().moveToTargetFloor(req.getFrom());
        Elevator.getInstance().moveToTargetFloor(req.getTo());
    }

    public Queue<Request> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Request> queue) {
        this.queue = queue;
    }
}
