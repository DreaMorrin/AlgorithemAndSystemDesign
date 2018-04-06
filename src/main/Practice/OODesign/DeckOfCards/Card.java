package main.Practice.OODesign.DeckOfCards;

public abstract class Card {
    private boolean avail = true;
    protected int faceValue;
    protected Suit suit;

    public Card (int c, Suit s) {
        this.faceValue = c;
        this.suit = s;
    }

    public abstract int value();
    public Suit suit() {
        return suit;
    }

    public boolean isAvailable() {
        return avail;
    }

    public void markUnAvailable() {
        avail = false;
    }

    public void markAvailable() {
        avail = true;
    }
}
