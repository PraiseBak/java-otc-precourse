package controller;

import domain.game.BetDto;
import domain.game.BlackJackGame;
import domain.player.Player;
import domain.player.Players;
import view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackController {
    public static void start(){
        List<String> usernameList = InputView.inputUserName();
        Players players = Players.from(usernameList);
        List<BetDto> betDtoList = players.collectBets();
        BlackJackGame blackJackGame = BlackJackGame.from(players,betDtoList);
        blackJackGame.init();
        blackJackGame.additionalDraw();
        blackJackGame.showCardResult();
        blackJackGame.showGameResult();
    }
}