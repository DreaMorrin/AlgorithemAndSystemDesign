package main.Practice.OODesign.AirportControlCenter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ControlCenter {
    private static ControlCenter instance = null;
    private PriorityQueue<Request> pq;
    private ControlCenter() {
        pq = new PriorityQueue<Request>(new Comparator<Request>() {
            @Override
            public int compare(Request r1, Request r2) {
                return r2.getPriority() - r1.getPriority();
            }
        });
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

    public void takeOff(int planeId) {

    }

    public void land(int planeId) {

    }

    public void addRequests(Request request) {
        if (request == null) {
            return;
        }
        this.pq.add(request);

    }
}
