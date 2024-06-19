package pairmatching.domain;

import pairmatching.helper.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairsGroup {
    private List<Pairs> pairsList = new ArrayList<>();

    public void addPairs(Crews crews, PairMatchOption pairMatchOption){
        for(int i=0;i<3;i++){
            removeSamePair(pairMatchOption);
            Pairs resultPairs = Pairs.createPairs(crews,pairMatchOption);
            if(isExistSamePairInSameLevel(pairMatchOption.level,resultPairs)){
                continue;
            }
            pairsList.add(resultPairs);
            return;
        }
        throw new IllegalArgumentException("페어를 만드는데 실패하였습니다");
    }

    private boolean isExistSamePairInSameLevel(Level level,Pairs resultPairs) {
        for(Pairs pairs : pairsList){
            if(!pairs.isSameLevel(level)) continue;
            if(pairs.isDuplicatePairExists(resultPairs)) return true;
        }
        return false;
    }

    public void removeSamePair(PairMatchOption pairMatchOption){
        for(Pairs pairs : pairsList){
            if(pairs.isSamePairs(pairMatchOption)){
                pairsList.remove(pairs);
                return;
            }
        }
    }

    public boolean isDuplicate(PairMatchOption pairMatchOption) {
        for(Pairs pairs : pairsList){
            if(pairs.isSamePairs(pairMatchOption)){
                return true;
            }
        }
        return false;
    }

    public void printAll() {
        for(Pairs pairs : pairsList){
            System.out.println(pairs.toString());
        }
    }

    public void clear() {
        pairsList = new ArrayList<>();
    }
}

