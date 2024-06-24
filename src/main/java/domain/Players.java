package domain;

import strategy.PlayerCardStrategy;
import view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private static List<Player> playerList;

    private Players(List<Player> playerList) {
        this.playerList = playerList;
    }
    private final Set<String> stopDrawPlayerList = new HashSet<>();


    public static Players from(List<String> usernameList){
        List<Player> playerList = new ArrayList<>();
        for (int id = 0; id < usernameList.size(); id++) {
            String username = usernameList.get(id);
            playerList.add(Player.from(username,id,new PlayerCardStrategy()));
        }
        return new Players(playerList);
    }

    public void drawCards() {
        for(Player player : playerList){
            player.drawCard();
        }
    }

    public void showPlayersCard() {
        for (Player player : playerList) {
            player.showCard();
        }
    }

    public void additionalDraw() {
        int stopDrawCount = 0;
        while (stopDrawCount != playerList.size()){
            Player player = playerList.get(stopDrawCount);
            if(!player.isDrawable()){
                stopDrawCount++;
                continue;
            }
            player.printUserInfo();
            boolean isDraw = InputView.inputMoreCard();
            if(!isDraw){
                player.stopDraw();
                continue;
            }
            player.drawCard();
            player.showCard();
        }
    }


    public List<GameResultDto> getGameResultList() {
        return playerList.stream()
                .map(Player::getGameResult)
                .collect(Collectors.toList());
    }

    public void showAllCards() {
        for(Player player : playerList){
            player.printUserInfo();
            player.showCards();
        }
    }
}