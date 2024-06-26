package domain.game;

public class BetDto {
    public String getUsername() {
        return username;
    }

    public double getBet() {
        return bet;
    }

    public BetDto(String username, double bet) {
        this.username = username;
        this.bet = bet;
    }

    public String username;
    public double bet;
}
