package pairmatching.domain;

import pairmatching.helper.Level;

import java.util.*;

public class Pairs{
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Pair pair : pairList){
            stringBuilder.append(pair.toString());
        }
        return stringBuilder.toString();
    }

    private List<Pair> pairList = new ArrayList<>();
    private final PairMatchOption pairMatchOption;


    public Pairs(List<Pair> pairList,PairMatchOption pairMatchOption) {
        this.pairList = pairList;
        this.pairMatchOption = pairMatchOption;
    }

    public static Pairs from(List<Pair> pairList,PairMatchOption pairMatchOption) {
        if(!checkDuplicate(pairList)) throw new IllegalArgumentException("중복된 페어입니다");
        return new Pairs(pairList,pairMatchOption);
    }

    public static Pairs createPairs(Crews crews,PairMatchOption pairMatchOption) {
        Pairs result = from(crews.createPairList(), pairMatchOption);
        return result;
    }

    private static boolean checkDuplicate(List<Pair> pairList) {
        HashSet<Pair> pairHashSet = new HashSet<>();
        for(Pair pair : pairList){
            int prevSize = pairHashSet.size();
            pairHashSet.add(pair);
            int afterSize = pairHashSet.size();
            if(prevSize == afterSize) return false;
        }
        return true;
    }

    //isDuplicatePairExists()
    public boolean isDuplicatePairExists(Pairs anotherPairList){
        HashSet<Pair> pairHashSet = new HashSet<>(pairList);
        for(Pair pair : anotherPairList.pairList){
            if(pairHashSet.contains(pair)) return true;
            pairHashSet.add(pair);
        }
        return false;
    }

    public boolean isSamePairs(PairMatchOption pairMatchOption){
        return this.pairMatchOption.equals(pairMatchOption);
    }

    public boolean isSameLevel(Level level){
        return level == pairMatchOption.level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pairs pairs = (Pairs) o;
        return Objects.equals(pairList, pairs.pairList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairList);
    }

    public int printPairListHashCode() {
        return pairList.hashCode();
    }
}
