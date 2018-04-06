package main.Practice.OODesign.VendingMachine;

public abstract class Item {
    private int count;
    private double price;
    private Position position;

    public Item(int count, double price, Position position) {
        this.count = count;
        this.price = price;
        this.position = position;
    }

    public void removeKItem(int k) {
        this.count -= k;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
