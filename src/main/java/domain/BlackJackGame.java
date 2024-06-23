package domain;

import strategy.DealerShowCardStrategy;

public class BlackJackGame{
    private final Players players;
    private final Player dealer;
    private final String DEALER_NAME = "딜러";

    public BlackJackGame(Players players) {
        this.players = players;
        this.dealer = Player.from(DEALER_NAME, new DealerShowCardStrategy());
    }

    public static BlackJackGame from(Players players) {
        return new BlackJackGame(players);
    }

    public void initCard() {
        players.drawCards();
        players.printCards();
        dealer.drawCard();
        dealer.showCards();
    }
}