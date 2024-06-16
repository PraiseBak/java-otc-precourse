package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pair implements Comparable<Pair>{
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

    @Override
    public int compareTo(Pair pair) {
        Collections.sort(pair.crewList);
        Collections.sort(this.crewList);

        String thisCrewListNames = this.crewList.stream()
                .map(Crew::getCrewName)
                .sorted() // 필요에 따라 정렬
                .collect(Collectors.joining(", "));
        String thatCrewListNames = pair.crewList.stream()
                .map(Crew::getCrewName)
                .sorted() // 필요에 따라 정렬
                .collect(Collectors.joining(", "));
        return thisCrewListNames.compareTo(thatCrewListNames);
    }
}
