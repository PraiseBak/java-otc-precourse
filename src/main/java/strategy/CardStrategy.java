package strategy;

import domain.Cards;

public interface CardStrategy {
    void show(Cards cards);
    void draw(Cards cards);
}
