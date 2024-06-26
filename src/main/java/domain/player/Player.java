package domain.player;

import domain.game.BetDto;
import domain.game.GameResultDto;
import domain.card.Cards;
import strategy.CardStrategy;
import view.InputView;
import view.OutputView;

import java.util.Objects;

public class Player implements BlackJackParticipation {
    private final CardStrategy cardStrategy;

    private Cards cards = new Cards();

    private final String username;
    private final int id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(username, player.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public BetDto bet() {
        int bet = InputView.inputBet();
        return new BetDto(username,bet);
    }
}