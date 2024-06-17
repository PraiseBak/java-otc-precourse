package pairmatching.domain;

import pairmatching.helper.Level;

import java.util.*;
import java.util.stream.Collectors;

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

    public boolean isSamePairExists(Pairs resultPairs) {
        List<Pair> sortedPairList = new ArrayList<>(resultPairs.pairList); // 기존 리스트 복사
        List<Pair> anotherPairList = new ArrayList<>(this.pairList); // 기존 리스트 복사;
        Collections.sort(sortedPairList); // 복사본 정렬
        Collections.sort(anotherPairList); // 복사본 정렬
        List<String> sortedPairStrList =  sortedPairList.stream()
                .map(Pair::toString)
                .collect(Collectors.toList());
        List<String> anotherSortedPairStrList =  anotherPairList.stream()
                .map(Pair::toString)
                .collect(Collectors.toList());
        for (int i = 0; i < sortedPairStrList.size(); i++) {
            if(sortedPairStrList.get(i).equals(anotherSortedPairStrList.get(i))) return true;
        }
        return false;
    }

}
