package domain;

public class GameResultDto {
    public GameResultDto(String username, int score) {
        this.username = username;
        this.score = score;
    }

    private String username;
    private int score;

    public int getScore() {
        return score;
    }

    public String getUsername() {
        return username;
    }
}
