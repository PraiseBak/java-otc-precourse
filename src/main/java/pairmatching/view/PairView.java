package pairmatching.view;

import pairmatching.ViewTextEnum;
import pairmatching.helper.InputValidCheck;

import java.util.Scanner;

public class PairView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputFunctionOption(){
        System.out.println(ViewTextEnum.FUNCTION_OPTION_INPUT.getText());
        String s = scanner.nextLine();
        InputValidCheck.checkInputFuntionOptionValid(s);
        int resultVal = 0;
        if(!s.equals("Q")) resultVal = Integer.parseInt(s);
        return resultVal;
    }

    public static void inputPairOption(){
        System.out.println(ViewTextEnum.PAIR_OPTION_INPUT.getText());
    }



}