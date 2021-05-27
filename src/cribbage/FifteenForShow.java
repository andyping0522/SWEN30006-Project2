package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class FifteenForShow extends IScoringRuleStrategy {
    private static final int FIFTEEN = 15;

    public FifteenForShow(ArrayList<Card> set) {
        super(set);
    }

    @Override
    public int getScore() {
        int result = 0;
        for (ArrayList<Card> subset:getSubsets()){
            if (isFifteen(subset)){
                result += 2;
            }
        }
        return result;
    }

    /**
     * Check whether the sum of a set of cards is 15
     * @param subset
     * @return boolean indicates the result
     */
    private boolean isFifteen(ArrayList<Card> subset){
        int sum = 0;
        for (Card card:subset){
            sum += card.getValue();
            if (sum == FIFTEEN){
                return true;
            }else if(sum > FIFTEEN){
                return false;
            }
        }
        return false;
    }
}