package main.Practice.OODesign.ComplexElevator;

public class Request {
    private int to;
    private int time;

    public Request (int to, int time) {
        this.to = to;
        this.time = time;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.to + " , time is: " + this.time;
    }
}
