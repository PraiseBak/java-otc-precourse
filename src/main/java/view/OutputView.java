package view;

import domain.card.Card;
import domain.game.GameResultDto;

import java.util.List;

public class OutputView {
    public static final String COMMA = ",";

    public static final String REQUEST_USERNAME_TEXT = "유저네임을 입력해주세요 [쉼표로 구분]";
    public static final String REQUEST_PLAYER_NUM = "플레이어 수를 입력해주세요 [숫자만 허용]";
    private static final String REQUEST_MORE_CARD = "카드를 더 뽑으시겠습니까? [y/n]";

//    public static final String PRINT_USERNAME= "유저네임을 입력해주세요";
public static final String PRINT_USER_INFO = "[%d번째 유저 %s님의 턴입니다]";
    public static final String PRINT_DRAW_CARD = "카드를 뽑았습니다";
    public static final String PRINT_WINNER = "[승자 발표]";
    private static final String PRINT_CANNOT_DRAW = "더이상 드로우할 수 없습니다";

    private static final String PRINT_ALL_WIN = "무승부입니다";
    private static final String PRINT_BET_REQUEST = "베팅해주세요 [숫자 형식]";
    private static final String PRINT_BET_RESULT = "베팅결과입니다 이름: %s 최종 수익: %f ";


    public static void printCurUser(int curUserIdx,String username){
        System.out.println(String.format(PRINT_USER_INFO,curUserIdx,username));
    }
    public static void printRequestUserName() {
        System.out.println(REQUEST_USERNAME_TEXT);
    }

    public static void printMoreCard() {
        System.out.println(REQUEST_MORE_CARD);
    }

    public static void printPlayerNum() {
        System.out.println(REQUEST_PLAYER_NUM);
    }


    public static void printCard(Card card) {
        System.out.println(card);
    }

    public static void printDraw() {
        System.out.println(PRINT_DRAW_CARD);
    }

    public static void printPlayerWin(List<GameResultDto> winnerGameResult) {
        System.out.println(PRINT_WINNER);
        for(GameResultDto gameResultDto : winnerGameResult){
            System.out.println(gameResultDto.getUsername() + COMMA + gameResultDto.getScore());
        }
    }

    public static void printAllWin() {
        System.out.println(PRINT_ALL_WIN);
    }

    public static void printBetRequest() {
        System.out.println(PRINT_BET_REQUEST);
    }

    public static void printBetResult(String username, Double betResult) {
        System.out.println(String.format(PRINT_BET_RESULT,username,betResult));

    }
}