package main.Practice.OODesign.PokerCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cardList;

    public Deck () {
        cardList = new ArrayList<>();
        Type[] types = {Type.CLUB, Type.DIAMOND, Type.HEART, Type.SPADE};
        String[] faceValues = {"A","2","3","4","5","6","7","8","9","10","j","q","k"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < faceValues.length; j++) {
                cardList.add(new Card(faceValues[j], types[i]));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cardList.size(); i++) {
            Random random = new Random();
            int index = i + random.nextInt(cardList.size() - i);
            Card nCard = cardList.get(index);
            Card oldCard = cardList.get(i);
            cardList.set(i, nCard);
            cardList.set(index, oldCard);
        }
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
