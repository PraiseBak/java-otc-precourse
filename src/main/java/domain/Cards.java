package domain;

import util.CardUtil;
import view.OutputView;

import java.util.*;

import static util.CardUtil.MAX_SCORE;
import static util.CardUtil.MIN_SCORE;

public class Cards {
    List<Card> cardList = new ArrayList<>();

    public void drawCard() {
        cardList.add(Deck.drawCard());
    }


    public boolean isBurst(){
        int score = calculateScore();
        if(!cardList.isEmpty() && score == MIN_SCORE) return true;
        return false;
    }

    public boolean isBlackjack(){
        int score = calculateScore();
        return score == MAX_SCORE;
    }

    public int calculateScore() {
        int totalScore = 0;
        int aceCount = 0;
        for (Card card : cardList) {
            int cardValue = card.getNum(); // 카드의 숫자 가져오기 (Ace = 1, 2-10, Jack/Queen/King = 10)
            totalScore += cardValue;
            if (cardValue == CardUtil.ACE_VALUE) { // Ace일 경우
                aceCount++;
                totalScore += CardUtil.ACE_HIGH_VALUE; // 일단 11점으로 계산
            }
        }
        while (aceCount > 0 && totalScore > CardUtil.MAX_SCORE) {
            totalScore -= CardUtil.ACE_HIGH_VALUE;
            aceCount--;
        }
        if (totalScore > MAX_SCORE) return CardUtil.MIN_SCORE; // 21을 초과할 경우 빈 Optional 반환
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

    public boolean drawable() {
        return !isBlackjack() && !isBurst();
    }

    public void showAllCard() {
        for(Card card : cardList){
            System.out.println(card);
        }
    }
}