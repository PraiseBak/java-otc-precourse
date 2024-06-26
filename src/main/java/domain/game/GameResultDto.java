package domain.game;

public class GameResultDto {
    @Override
    public String toString() {
        return "GameResultDto{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }

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
