package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair{
    @Override
    public String toString() {
        return "Pair{" +
                "crewList=" + crewList +
                '}';
    }

    List<Crew> crewList = new ArrayList<>();

    public static Pairs createPair(Crews crews) {
        crews.shuffle();
        Pairs pairs = crews.createPair();
        return pairs;
    }

    Pair(List<Crew> crewList){
        this.crewList = crewList;
    }


    public static Pair from(List<Crew> crewList) {
        return new Pair(crewList);
    }

}
