package view;

import error.IllegalInputException;
import error.InputErrorEnum;
import validate.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);

    public static List<String> inputUserName(){
        OutputView.printRequestUserName();
        String username = sc.nextLine();
        if(!InputValidator.validateUsername(username)) throw new IllegalInputException(InputErrorEnum.INVALID_USERNAME);
        return Arrays
                .stream(username.split(","))
                .collect(Collectors.toList());
    }

    public static boolean inputMoreCard(){
        OutputView.printMoreCard();
        String response = sc.nextLine();
        if(!InputValidator.validateMoreCard(response)) throw new IllegalInputException(InputErrorEnum.INVALID_RESPONSE);
        return response.equals("y");
    }








}