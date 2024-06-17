package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pair implements Comparable<Pair>{
    List<Crew> crewList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(crewList, pair.crewList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Crew crew : crewList) {
            stringBuilder.append(crew);
            stringBuilder.append(" : ");
        }
        stringBuilder = stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(":"));
        stringBuilder.append("\n");
        return stringBuilder.toString();

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

    public void addCrew(List<Crew> pairCrewList) {
        this.crewList.addAll(pairCrewList);

    }
}
