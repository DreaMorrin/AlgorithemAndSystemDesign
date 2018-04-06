package main.Practice.OODesign.DeckOfCards;

public enum Suit {
    Club (0),
    Diamond (1),
    Heart (2),
    Spade (3);

    private int value;
    private Suit(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int val) {
        Suit s = null;
        switch(val) {
            case 0: s = Club; break;
            case 1: s = Diamond; break;
            case 2: s = Heart; break;
            case 3: s = Spade; break;
        }
        return s;
    }
}
