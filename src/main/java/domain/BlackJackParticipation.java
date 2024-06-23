package domain;

public interface BlackJackParticipation {
    public void drawCard();

    /**
     * 플레이어면 burst
     * 딜러면 17초과
     * @return boolean
     */
    public boolean isDrawable();

    public void showCards();



}
