package pairmatching.controller;

import pairmatching.domain.Crews;
import pairmatching.domain.Pair;
import pairmatching.domain.PairFileUtil;
import pairmatching.domain.Pairs;
import pairmatching.view.PairView;

import java.util.HashMap;
import java.util.HashSet;

import static pairmatching.domain.PairFileUtil.getInitialCrewsFromFile;

public class PairController {
    HashSet<Pairs> pairsHashSet = new HashSet<>();
    static Pairs pairs;

    public static void start(){
        Crews crews = getInitialCrewsFromFile();
        try{

            int option = PairView.inputFunctionOption();
            if(option == 0) return; //Q일때

            /**
             * createPair하다가 맘 Crew로 Pair만들기
             */
            if(option == 1) {
                pairs = Pair.createPair(crews);
                //TODO Pair 중복 체크 추가

            }
            if(option == 2){
                pairs.print();
            }
            if(option == 3){
                pairs.removeAll();
            }

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }









    }
}