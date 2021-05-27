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
        HashMap<Integer, ArrayList<Card>> dict = generateMap();
        for (Integer key:dict.keySet()){
            if (dict.get(key).size() > 1){
                result += dict.get(key).size();
            }
        }
        return result * 2;

    }

    private HashMap<Integer, ArrayList<Card>> generateMap(){
        HashMap<Integer, ArrayList<Card>> dict = new HashMap<Integer, ArrayList<Card>>();
        for (Card card:getSet()){
            int val = card.getValue();
            if (dict.get(val) == null){
                dict.put(val, new ArrayList<Card>());
            }
            dict.get(val).add(card);
        }
        return dict;
    }
}