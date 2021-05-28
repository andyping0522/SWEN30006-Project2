package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class PairForShow extends IScoringRuleStrategy{

    public PairForShow(ArrayList<Card> set) {
        super(set);
    }

    @Override
    public int getScore() {
        int result = 0;
        HashMap<Cribbage.Rank, ArrayList<Card>> dict = generateMap();
        for (Cribbage.Rank key:dict.keySet()){
            if (dict.get(key).size() > 1){
                result += dict.get(key).size()*2;
            }
        }
        return result;

    }

    private HashMap<Cribbage.Rank, ArrayList<Card>> generateMap(){
        HashMap<Cribbage.Rank, ArrayList<Card>> dict = new HashMap<Cribbage.Rank, ArrayList<Card>>();
        for (Card card:getSet()){
            Cribbage.Rank val = (Cribbage.Rank) card.getRank();
            if (dict.get(val) == null){
                dict.put(val, new ArrayList<>());
            }
            dict.get(val).add(card);
        }
        return dict;
    }
}