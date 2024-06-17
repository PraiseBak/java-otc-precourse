package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.helper.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    public Course getCourse() {
        return course;
    }

    private final Course course;

    @Override
    public String toString() {
        return crewList.stream().map((crew) -> crew.toString()).collect(Collectors.joining(","));
    }


    private List<Crew> crewList;

    public int getSize(){
        return crewList.size();
    }

    public Crews(List<Crew> crewList,Course course) {
        this.course = course;
        this.crewList = crewList;
    }

    public Crews shuffle(){
        return Crews.ofCrewList(Randoms.shuffle(crewList),course);
    }

    public static Crews ofCrewList(List<Crew> crewList,Course course) {
        return new Crews(crewList,course);
    }

    public static Crews of(List<String> crewNameArr,Course course) {
        return new Crews(crewNameArr.stream().map((crewName) -> new Crew(crewName,course)).collect(Collectors.toList()),course);
    }

    public List<Pair> createPairList() {
        List<Pair> pairList = new ArrayList<>();
        List<Crew> pairCrewList = new ArrayList<>();

        for(int i=0;i<crewList.size();i++){
            pairCrewList.add(crewList.get(i));
            if(pairCrewList.size() == 2){
                pairList.add(Pair.from(pairCrewList));
                pairCrewList = new ArrayList<>();
            }
        }
        if(crewList.size() % 2 != 0) pairList.get(pairList.size()-1).addCrew(pairCrewList);
        return pairList;
    }
}
