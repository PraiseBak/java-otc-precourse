package strategy;

import domain.Card;
import domain.Cards;

import java.util.List;

public class PlayerDrawStrategy implements ShowCardStrategy{
    public void show(Cards cards) {
        cards.showLastCard();
    }
}
