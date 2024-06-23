package controller;

import domain.BlackJackGame;
import domain.Players;
import view.InputView;

import java.util.List;

public class BlackJackController {
    public static void start(){
        List<String> usernameList = InputView.inputUserName();
        Players players = Players.from(usernameList);
        BlackJackGame blackJackGame = BlackJackGame.from(players);
        blackJackGame.initCard();
    }
}