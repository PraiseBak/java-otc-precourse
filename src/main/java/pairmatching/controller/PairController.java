package pairmatching.controller;

import pairmatching.domain.*;
import pairmatching.view.PairView;

import java.util.HashSet;
import java.util.List;

import static pairmatching.domain.PairFileUtil.getInitialCrewsListFromFile;

public class PairController {
    HashSet<Pair> pairHashSet = new HashSet<>();
    static PairsGroup pairsGroup = new PairsGroup();


    public static void start(){
        CrewGroup crewGroup = CrewGroup.from(getInitialCrewsListFromFile());
        while (true){
            int option = PairView.inputFunctionOption();
            if(option == 0) return; //Q일때

            if(option == 1) {
                PairMatchOption pairMatchOption = PairView.inputPairMatchOption();
                PairView.addPairView(crewGroup,pairsGroup,pairMatchOption);
            }

            if(option == 2){
                pairsGroup.printAll();
            }
            if(option == 3){
                pairsGroup.clear();
            }
        }


    }
}