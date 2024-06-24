package strategy;

import domain.Cards;

public class PlayerCardStrategy implements CardStrategy {
    public void show(Cards cards) {
        cards.showLastCard();
    }

    @Override
    public void draw(Cards cards) {
        if(cards.drawable()){
            cards.drawCard();
        }
    }
}
