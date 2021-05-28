package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class FifteenForPlay extends IScoringRuleStrategy{
    public FifteenForPlay(ArrayList<Card> set) {
        super(set);

    }

    @Override
    public int getScore() {
        int sum = 0;
        for (Card card:getSet()){
            //System.out.println(card.getValue());
            sum += Cribbage.cardValue(card);
            if (sum > 15){
                return 0;
            }
        }
        if (sum == 15){
            return 2;
        }else{
            return 0;
        }

    }
}