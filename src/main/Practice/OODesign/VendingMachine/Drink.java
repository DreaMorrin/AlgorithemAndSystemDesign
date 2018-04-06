package main.Practice.OODesign.VendingMachine;

public class Drink extends Item {
    private Type type;

    public Drink (Type type, int count, double price, Position position) {
        super(count, price, position);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
