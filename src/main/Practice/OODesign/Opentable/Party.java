package main.Practice.OODesign.Opentable;

public class Party {
    private long id;
    private int numOfPeople;
    private Interval bookTime;


    public Party(long id, int num, Interval interval) {
        this.id = id;
        this.numOfPeople = num;
        this.bookTime = interval;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Interval getBookTime() {
        return bookTime;
    }

    public void setBookTime(Interval bookTime) {
        this.bookTime = bookTime;
    }
}
