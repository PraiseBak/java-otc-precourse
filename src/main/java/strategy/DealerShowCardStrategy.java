package strategy;

import domain.Cards;
import view.OutputView;

public class DealerShowCardStrategy implements ShowCardStrategy{

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
}
