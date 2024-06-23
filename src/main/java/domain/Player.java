package domain;

public class Player implements DrawStrategy {
    Cards cards = new Cards();

    String username;

    private Player(String username){
        this.username = username;
    }


    public static Player from(String username) {
        return new Player(username);
    }
}