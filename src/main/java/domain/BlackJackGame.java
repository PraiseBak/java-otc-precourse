package domain;

import strategy.DealerCardStrategy;
import view.OutputView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame{
    private final Players players;
    private final Player dealer;
    private final String DEALER_NAME = "딜러";

    public BlackJackGame(Players players) {
        int dealerId = -1;
        this.players = players;
        this.dealer = Player.from(DEALER_NAME,dealerId,new DealerCardStrategy());
    }

    public static BlackJackGame from(Players players) {
        return new BlackJackGame(players);
    }

    public void init() {
        players.drawCards();
        players.showPlayersCard();
        players.drawCards();
        players.showPlayersCard();

        dealer.drawCard();
        dealer.drawCard();
        dealer.showCard();
    }

    //추가 드로우
    public void additionalDraw(){
        players.additionalDraw();
    }

    //마지막 전체 카드 목록
    public void showCardResult() {
        players.showAllCards();
        dealer.showCards();
    }




    //최종 승패
    public void showGameResult() {
        List<GameResultDto> gameResultDtoList = players.getGameResultList();
        int dealerScore = dealer.getScore();
        List<GameResultDto> dealerWinGameResultDtoList = getDealerWinGameResult(dealerScore,gameResultDtoList);
        GameResultDto unrivaledGameResult = getUnrivaledGameResult(dealerWinGameResultDtoList);
        GameResultDto dealerResult = new GameResultDto(DEALER_NAME,dealerScore);

        if (isDealerWin(dealerWinGameResultDtoList, dealerResult)) return;
        if (isPlayerWin(dealerWinGameResultDtoList)) return;
        if (isAllWin(unrivaledGameResult, dealerScore)) return;
        //점수 비교해서 승자 한명만 남기기
        playerWin(Collections.singletonList(unrivaledGameResult));
    }

    private boolean isAllWin(GameResultDto unrivaledGameResult, int dealerScore) {
        //가장 높은 점수인데 딜러와 같으면 무승부
        if(unrivaledGameResult.getScore() == dealerScore){
            allWin();
            return true;
        }
        return false;
    }

    private boolean isPlayerWin(List<GameResultDto> dealerWinGameResultDtoList) {
        //딜러 버스트면
        if(dealer.isBurst()){
            playerWin(dealerWinGameResultDtoList);
            return true;
        }
        return false;
    }

    private boolean isDealerWin(List<GameResultDto> dealerWinGameResultDtoList, GameResultDto dealerResult) {
        //모든 플레이어가 버스트 or 딜러가 가장 높음
        if(dealerWinGameResultDtoList.isEmpty()){
            dealerWin(dealerResult);
            return true;
        }
        return false;
    }

    private GameResultDto getUnrivaledGameResult(List<GameResultDto> gameResultDtoList) {
        return gameResultDtoList.stream()
                .max(Comparator.comparingInt(GameResultDto::getScore))
                .orElse(null); // 리스트가 비어있을 경우 null 반환
    }

    private List<GameResultDto> getDealerWinGameResult(int dealerScore, List<GameResultDto> gameResultDtoList) {
        return gameResultDtoList.stream()
                .filter((gameResultDto) -> gameResultDto.getScore() > dealerScore)
                .collect(Collectors.toList());


    }

    public void allWin(){
        OutputView.printAllWin();
    }

    public void playerWin(List<GameResultDto> winnerGameResult){
        OutputView.printPlayerWin(winnerGameResult);
    }

    public void dealerWin(GameResultDto dealerResult){
        OutputView.printPlayerWin(Collections.singletonList(dealerResult));
    }
}