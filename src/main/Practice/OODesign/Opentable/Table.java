package main.Practice.OODesign.Opentable;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private long id;
    private int capacity;
    private Type type;
    private Status status;
    private long[][] avaialbeTime;

    public Table(long id, int capacity, Type type) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
        this.status = Status.PENDING;
        this.avaialbeTime = new long[12][2];
        for (int i = 0; i < avaialbeTime.length; i++) {
            avaialbeTime[i][0] = 11 + i;
            avaialbeTime[i][1] = 11 + i + 1;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long[][] getAvaialbeTime() {
        return avaialbeTime;
    }

    public void setAvaialbeTime(long[][] avaialbeTime) {
        this.avaialbeTime = avaialbeTime;
    }
}
