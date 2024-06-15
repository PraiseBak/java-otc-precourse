package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.helper.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private List<Crew> crewList;

    public int getSize(){
        return crewList.size();
    }

    public Crews(List<Crew> crewList) {
        this.crewList = crewList;
    }


    /**
     * within side effect
     */
    public void shuffle(){
        this.crewList = Randoms.shuffle(crewList);
    }
    /**
     * without side effect
     * todo side effect없어야함 왜냐하면 재요청했을때 똑같은 값이 나와야하니까
     */
    public void shuffle2(){
        this.crewList = Randoms.shuffle(crewList);
    }

    public static Crews of(List<String> crewNameArr,Course course) {
        return new Crews(crewNameArr.stream().map((crewName) -> new Crew(crewName,course)).collect(Collectors.toList()));
    }

    public Crews combine(Crews other){
        this.crewList.addAll(other.crewList);
        return new Crews(Collections.unmodifiableList(this.crewList));
    }

    public Pairs createPair() {
        List<Pair> pairList = new ArrayList<>();
        List<Crew> pairCrewList = new ArrayList<>();
        //함수형으로 하면 좋을듯
        for(int i=0;i<crewList.size();i++){
            if(i % 2 == 0){
                pairList.add(Pair.from(pairCrewList));
                pairCrewList = new ArrayList<>();
            }
            pairCrewList.add(pairCrewList.get(i));
        }

        if(pairCrewList.size() % 2 != 0){
            pairCrewList.add(crewList.get(crewList.size()-1));
            pairList.add(Pair.from(pairCrewList));
        }
        return Pairs.from(pairList);
    }
}
