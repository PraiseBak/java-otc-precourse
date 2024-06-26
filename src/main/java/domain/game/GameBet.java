package domain.game;

import domain.player.Player;
import domain.player.Players;
import util.CardUtil;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBet {
    private final Players players;
    private final Player dealer;
    private final Map<String,Double> betResultMap = new HashMap<>();

    public GameBet(Players players, Player dealer, List<BetDto> betDtoList) {
        this.players = players;
        this.dealer = dealer;
        betDtoList.forEach(betDto -> {
            System.out.println(betDto.getUsername());
            betResultMap.put(betDto.getUsername(), betDto.bet);
        });

        betResultMap.keySet()
                        .forEach((key) -> System.out.println(key + "," + betResultMap.get(key)));

        System.out.println(betResultMap);

    }

    public static GameBet from(Players players, Player dealer, List<BetDto> betDtoList) {
        return new GameBet(players,dealer,betDtoList);
    }


    //딜러가 이김
    //딜러가 다른 플레이어의 베팅을 모두 몰수한다
    public void dealerWin(GameResultDto dealerGameResultDto, List<GameResultDto> loseOrDrawByDealerGameResultDtoList) {
        String dealerName = dealerGameResultDto.getUsername();
        loseOrDrawByDealerGameResultDtoList.stream()
            .filter((gameResultDto) -> gameResultDto.getScore() != dealerGameResultDto.getScore())
            .forEach(losePlayerDto -> moneyToDealer(losePlayerDto.getUsername(),dealerName));
    }

    //딜러가 이김
    //딜러가 다른 플레이어의 베팅을 모두 몰수한다
    public void playerWin(GameResultDto dealerGameResultDto, List<GameResultDto> winnerByDealerGameResultDtoList) {
        String dealerName = dealerGameResultDto.getUsername();
        winnerByDealerGameResultDtoList.stream()
            .forEach(winnerPlayerDto -> moneyToPlayer(winnerPlayerDto.getUsername(),dealerName,winnerPlayerDto.getScore() == CardUtil.MAX_SCORE));
    }


    //딜러가 이겼을때
    private void moneyToDealer(String loseUsername, String winnerDealer) {
        Double loseUserMoney = betResultMap.get(loseUsername);
        Double dealerMoney = betResultMap.get(winnerDealer);
        double zero = 0;
        System.out.println("lose =" + loseUsername);

        betResultMap.put(winnerDealer, dealerMoney + loseUserMoney);
        betResultMap.put(loseUsername, zero - loseUserMoney);
    }

    public void moneyToPlayer(String winnerUsername,String loseDealer,boolean isBlackjack) {
        System.out.println("win = " + winnerUsername);
        Double winUserMoney = betResultMap.get(winnerUsername);
        Double dealerMoney = betResultMap.get(loseDealer);
        Double multiple = 1.0;
        if(isBlackjack) multiple = 1.5;
        Double afterMultipleMoney = winUserMoney * multiple;

        betResultMap.put(winnerUsername, afterMultipleMoney);
        betResultMap.put(loseDealer, dealerMoney - afterMultipleMoney);
    }

    public void calculateBet(List<GameResultDto> winByDealerGameResultDtoList, List<GameResultDto> loseOrDrawByDealerGameResultDtoList, GameResultDto dealerResult) {
        betResultMap.put(dealerResult.getUsername(), (double) 0);
        dealerWin(dealerResult,loseOrDrawByDealerGameResultDtoList);
        playerWin(dealerResult,winByDealerGameResultDtoList);
    }

    public void printBetResult() {
        betResultMap.keySet().stream()
                .forEach((key) -> OutputView.printBetResult(key,betResultMap.get(key)));
    }
}
