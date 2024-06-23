package domain;

import view.OutputView;

import java.util.*;

public class Cards {
    List<Card> cardList = new ArrayList<>();

    public void drawCard() {
        cardList.add(Deck.drawCard());
    }



    public boolean isDrawable(){
        int score = calculateScore();
        if(score >= 21) return false;
        return true;
    }

    public int calculateScore() {
        int totalScore = 0;
        int aceCount = 0;
        final int ACE_VALUE = 1;
        final int MIN_SCORE = 1;
        final int MAX_SCORE = 21;
        final int ACE_HIGH_VALUE = 10;

        for (Card card : cardList) {
            int cardValue = card.getNum(); // 카드의 숫자 가져오기 (Ace = 1, 2-10, Jack/Queen/King = 10)
            totalScore += cardValue;
            if (cardValue == ACE_VALUE) { // Ace일 경우
                aceCount++;
                totalScore += ACE_HIGH_VALUE; // 일단 11점으로 계산
            }
        }

        while (aceCount > 0 && totalScore > MAX_SCORE) {
            totalScore -= ACE_HIGH_VALUE;
            aceCount--;
        }

        if (totalScore > MAX_SCORE) {
            return MIN_SCORE; // 21을 초과할 경우 빈 Optional 반환
        }

        return totalScore; // 유효한 점수를 포함하는 Optional 반환
    }

    public void showLastCard() {
        int lastNumIdx = cardList.size()-1;
        OutputView.printCard(cardList.get(lastNumIdx));
    }


    public void showFirstCard() {
        int startIdx = 0;
        OutputView.printCard(cardList.get(startIdx));
    }
}