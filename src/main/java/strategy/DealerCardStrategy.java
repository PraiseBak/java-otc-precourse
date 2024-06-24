package strategy;

import domain.Cards;
import view.OutputView;

public class DealerCardStrategy implements CardStrategy {

    private boolean isFirst = true;
    @Override
    public void show(Cards cards) {
        if(isFirst){
            isFirst = false;
            cards.showFirstCard();
            return;
        }
        OutputView.printDraw();
    }

    @Override
    public void draw(Cards cards) {
        int dealerMinNum = 17;
        if(cards.calculateScore() < dealerMinNum){
            cards.drawCard();
        }
    }
}
