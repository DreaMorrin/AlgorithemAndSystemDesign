package main.Practice.OODesign.CallController;

public enum Rank {
    Respondant(0),
    Manager(1),
    Director(2);

    private final int value;

    private Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
