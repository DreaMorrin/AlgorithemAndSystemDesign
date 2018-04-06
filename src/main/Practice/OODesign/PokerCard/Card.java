package main.Practice.OODesign.PokerCard;

public class Card {
    private String faceValue;
    private Type type;

    public Card(String faceValue, Type type) {
        this.faceValue = faceValue;
        this.type = type;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}