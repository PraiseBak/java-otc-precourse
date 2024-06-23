package domain;

import java.lang.reflect.Type;
import java.util.Enumeration;

public class Card {
    public CardType getType() {
        return type;
    }

    public int getNum() {
        return num;
    }

    private static final String CARD_PRINT_FORMAT = "카드는 [%s %d] 입니다";

    @Override
    public String toString() {
        return String.format(CARD_PRINT_FORMAT,type.getCardTypeStr(),num);
    }

    //문양
    private final CardType type;

    //번호
    private final int num;

    public Card(CardType type, int num) {
        this.type = type;
        this.num = num;
    }

    public static Card from(CardType cardType, int cardNum) {
        return new Card(cardType,cardNum);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}