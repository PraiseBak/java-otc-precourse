package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private static List<Player> playerList;

    private Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public static Players from(List<String> username){
        List<Player> playerList = new ArrayList<>();s
        for(String s : username){
            playerList.add(Player.from(s));
        }

        return new Players(playerList);
    }
}