package domain;

import strategy.ShowCardStrategy;

import java.util.HashSet;

public class Player implements BlackJackParticipation{
    private ShowCardStrategy showCardStrategy;

    Cards cards = new Cards();

    String username;


    private Player(String username,ShowCardStrategy showCardStrategy){
        this.username = username;
        this.showCardStrategy = showCardStrategy;
    }


    public static Player from(String username,ShowCardStrategy showCardStrategy) {
        return new Player(username,showCardStrategy);
    }

    @Override
    public void drawCard() {
        if(isDrawable()){
            cards.drawCard();
        }
    }

    @Override
    public boolean isDrawable() {
        return cards.isDrawable();
    }

    public int getScore() {
        return cards.calculateScore();
    }

    @Override
    public void showCards() {
        showCardStrategy.show(cards);
        cards.showLastCard();
    }
}