package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pairs{
    private List<Pair> pairList = new ArrayList<>();

    public Pairs(List<Pair> pairList) {
        this.pairList = pairList;
    }

    public static Pairs from(List<Pair> pairList) {
        return new Pairs(pairList);
    }

    public void removeAll() {
        this.pairList = new ArrayList<>();
    }

    public void print() {
        for(Pair pair : pairList){
            System.out.println(pair);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        //pairList를 정렬한 뒤 String으로 mapping하여 확인
        Pairs pairs = (Pairs) o;
        return Objects.equals(pairList, pairs.pairList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairList);
    }
}
