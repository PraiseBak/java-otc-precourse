package view;

import error.IllegalInputException;
import error.InputErrorEnum;
import validate.InputValidator;

public class OutputView {
    public static final String REQUEST_USERNAME_TEXT = "유저네임을 입력해주세요 [쉼표로 구분]";
    public static final String REQUEST_PLAYER_NUM = "플레이어 수를 입력해주세요 [숫자만 허용]";
    private static final String REQUEST_MORE_CARD = "카드를 더 뽑으시겠습니까? [y/n]";

//    public static final String PRINT_USERNAME= "유저네임을 입력해주세요";
    public static final String PRINT_USER_INFO = "[%d번째 유저 %s님의 턴입니다]";



    public static void printCurUser(int curUserIdx,String username){
        System.out.println(String.format(PRINT_USER_INFO,curUserIdx,username));
    }
    public static void printUserName() {
        System.out.println(REQUEST_USERNAME_TEXT);
    }

    public static void printMoreCard() {
        System.out.println(REQUEST_MORE_CARD);
    }

    public static void printPlayerNum() {
        System.out.println(REQUEST_PLAYER_NUM);
    }



}