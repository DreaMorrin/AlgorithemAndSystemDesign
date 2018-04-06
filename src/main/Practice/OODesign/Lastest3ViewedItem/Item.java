package main.Practice.OODesign.Lastest3ViewedItem;

public class Item {
    private String id;
    private int timeStamp;
    public Item(String id, int timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

}
