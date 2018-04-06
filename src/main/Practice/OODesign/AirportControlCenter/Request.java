package main.Practice.OODesign.AirportControlCenter;

public class Request {
    private int planeId;
    private int priority;
    private Action action;

    public Request(int planeId, int priority, Action action) {
        this.planeId = planeId;
        this.priority = priority;
        this.action = action;
    }
    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
