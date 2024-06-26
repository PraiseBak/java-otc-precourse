package strategy;

import domain.card.Cards;

public interface CardStrategy {
    void show(Cards cards);
    void draw(Cards cards);
}
