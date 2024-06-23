package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    static List<Card> cardList = new ArrayList<>();
    private static final int SPECIAL_CARD_SIZE = 3;
    private static final int SPECIAL_CARD_NUM = 10;
    private static final int NORMAL_CARD_SIZE = 10;

    static {
        List<CardType> cardTypeList = List.of(CardType.values());

        for(CardType cardType : cardTypeList){
            //1(ACE 취급)부터 10
            for (int i = 1; i <= NORMAL_CARD_SIZE; i++) {
                cardList.add(Card.from(cardType,i));
            }

            //QJK
            for (int i = 0; i < SPECIAL_CARD_SIZE; i++) {
                cardList.add(Card.from(cardType,SPECIAL_CARD_NUM));
            }
        }

    }



    public static Card drawCard() {
        Random random = new Random();
        int index = random.nextInt(cardList.size());
        return cardList.remove(index);
    }
}