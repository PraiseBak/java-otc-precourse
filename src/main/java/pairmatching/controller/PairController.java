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
    HashSet<Pair> pairHashSet = new HashSet<>();
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
                /**
                 * TODO 중복 체크 기능 구현 계획
                 * 현재 상황 = duplicate check 구현중에 있는데
                 * pairs를 이용할게 아니라 각 pair를 hashset에 넣어서 중복인지 확인할 것임
                 * 이것은 생성자에서 hashset을 새로 추가해서 크기가 바뀌는지 확인하고 그렇지 않으면 throw해서 그 thorw를 catch하는 식으로
                 * 중복체크를 할 것인데 이때 throw를 무엇으로 할 것인지 custom할 것인지 아니면 throw할때 에러 문자만 다르게 해서 출력해주고 항상 다시 실행될 것인지
                 * 아마 맨 마지막줄에 적은 방식대로 할 것 같음
                 *
                 * @param crews
                 * @return
                 */




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