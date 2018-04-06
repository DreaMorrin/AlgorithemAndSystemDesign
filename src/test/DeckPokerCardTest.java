package test;

import main.Practice.OODesign.PokerCard.Card;
import main.Practice.OODesign.PokerCard.Deck;
import org.junit.jupiter.api.Test;

public class DeckPokerCardTest {
    @Test
    public void testCase1() {
        Deck deck = new Deck();
        deck.shuffle();
        int count = 1;
        for (Card c : deck.getCardList()) {
            System.out.print(c.getFaceValue() + " ");
            if (count % 13 == 0) {
                System.out.println();
            }
            count++;
        }
    }
}
