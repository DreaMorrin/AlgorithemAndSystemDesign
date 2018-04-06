package main.Practice.OODesign.ElevatorSystem;

public class User {
    private int from;
    private int to;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void pressButton(int from, int to) {
        Controller controller = Controller.getInstance();
        controller.getQueue().offer(new Request(from, to));
    }
}

