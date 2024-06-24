package domain;

import strategy.CardStrategy;
import view.OutputView;

public class Player implements BlackJackParticipation{
    private final CardStrategy cardStrategy;

    private Cards cards = new Cards();

    private final String username;
    private final int id;
    //유저가 드로우를 그만하기로함
    private boolean stopDraw = false;


    private Player(String username, int id, CardStrategy cardStrategy){
        this.username = username;
        this.cardStrategy = cardStrategy;
        this.id = id;
    }


    public static Player from(String username, int id, CardStrategy cardStrategy) {
        return new Player(username,id, cardStrategy);
    }

    @Override
    public void drawCard() {
        cardStrategy.draw(cards);
    }

    @Override
    public boolean isBurst() {
        return cards.isBurst();
    }

    public int getScore() {
        return cards.calculateScore();
    }

    @Override
    public void showCard() {
        printUserInfo();
        cardStrategy.show(cards);
    }




    public void printUserInfo() {
        OutputView.printCurUser(id,username);
    }


    public boolean isBlackjack(){
        return cards.isBlackjack();
    }

    public boolean isDrawable(){
        return !stopDraw && !isBurst() && !isBlackjack();
    }

    public void stopDraw(){
        this.stopDraw = true;
    }

    public GameResultDto getGameResult() {
        return new GameResultDto(username,getScore());
    }

    public void showCards() {
        printUserInfo();
        cards.showAllCard();
    }
}