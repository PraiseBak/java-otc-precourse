package domain.game;

import domain.player.Player;
import domain.player.Players;
import strategy.DealerCardStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame{
    private final Players players;
    private final Player dealer;
    private GameBet gameBet;
    private final static String DEALER_NAME = "딜러";

    public BlackJackGame(Players players, List<BetDto> betDtoList) {
        int dealerId = -1;
        this.players = players;
        this.dealer = Player.from(DEALER_NAME,dealerId,new DealerCardStrategy());
        this.gameBet = GameBet.from(players,dealer,betDtoList);
    }

    public static BlackJackGame from(Players players,List<BetDto> betDtoList) {
        return new BlackJackGame(players,betDtoList);
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
        int dealerScore = dealer.getScore();
        List<GameResultDto> gameResultDtoList = players.getGameResultList();
        List<GameResultDto> winByDealerGameResultDtoList = getWinByDealerGameResult(dealerScore,gameResultDtoList);
        List<GameResultDto> loseOrDrawByDealerGameResultDtoList = getLoseOrDrawByDealerGameResult(dealerScore,gameResultDtoList);
        System.out.println(winByDealerGameResultDtoList.size());
        System.out.println(loseOrDrawByDealerGameResultDtoList.size());
        GameResultDto dealerResult = new GameResultDto(DEALER_NAME,dealerScore);

        gameBet.calculateBet(winByDealerGameResultDtoList,loseOrDrawByDealerGameResultDtoList,dealerResult);
        gameBet.printBetResult();
    }

    private List<GameResultDto> getLoseOrDrawByDealerGameResult(int dealerScore, List<GameResultDto> gameResultDtoList) {
        // 이긴 사람들의 리스트를 제외한 전체 리스트를 필터링
        return gameResultDtoList.stream()
                .filter((gameResultDto) -> gameResultDto.getScore() <= dealerScore)
                .collect(Collectors.toList());
    }

    private List<GameResultDto> getWinByDealerGameResult(int dealerScore, List<GameResultDto> gameResultDtoList) {
        return gameResultDtoList.stream()
                .filter((gameResultDto) -> gameResultDto.getScore() > dealerScore)
                .collect(Collectors.toList());


    }

}