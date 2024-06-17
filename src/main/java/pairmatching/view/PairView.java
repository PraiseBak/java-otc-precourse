package pairmatching.view;

import pairmatching.ViewTextEnum;
import pairmatching.domain.CrewGroup;
import pairmatching.domain.Crews;
import pairmatching.domain.PairMatchOption;
import pairmatching.domain.PairsGroup;
import pairmatching.helper.InputValidCheck;

import java.util.Scanner;

public class PairView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputFunctionOption(){
        while (true){
            try{
                System.out.println(ViewTextEnum.FUNCTION_OPTION_INPUT.getText());
                String s = scanner.nextLine();
                InputValidCheck.checkInputFuntionOptionValid(s);
                int resultVal = 0;
                if(!s.equals("Q")) resultVal = Integer.parseInt(s);
                return resultVal;

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void inputPairOption(){
        System.out.println(ViewTextEnum.PAIR_OPTION_INPUT.getText());
    }

    public static PairMatchOption inputPairMatchOption() {
        while(true){
            System.out.println(ViewTextEnum.PAIR_OPTION_INPUT.getText());
            try{
                String inputLine = scanner.nextLine();
                String[] inputLineList = inputLine.replaceAll(" ","").split(",");
                return PairMatchOption.of(inputLineList[0],inputLineList[1],inputLineList[2]);
            }catch (Exception e){
                System.out.println("[ERROR] 유효하지 않은 입력입니다");
            }
        }
    }

    public static void addPairView(CrewGroup crewGroup, PairsGroup pairsGroup, PairMatchOption pairMatchOption) {
        if(pairsGroup.isDuplicate(pairMatchOption)){
            System.out.println(ViewTextEnum.PAIR_EXISTS_MSG.getText());
            String input = scanner.nextLine();
            if(input.equals("아니오")) return;
        }

        try{
            Crews crews = crewGroup.getCrewsByCourse(pairMatchOption.getCourse());
            pairsGroup.addPairs(crews,pairMatchOption);
            return;
        }catch (Exception e){
            System.out.println("[ERROR]" + e.getMessage());
            return;
        }
    }
}