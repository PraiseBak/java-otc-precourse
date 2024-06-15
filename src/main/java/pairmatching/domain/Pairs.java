package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

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

}
