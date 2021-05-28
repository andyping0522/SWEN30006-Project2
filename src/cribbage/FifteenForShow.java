package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class FifteenForShow extends IScoringRuleStrategy {
    private static final int FIFTEEN = 15;

    public FifteenForShow(ArrayList<Card> set, IPlayer player) {
        super(set, player);
    }

    @Override
    public int getScore() {
        int result = 0;
        for (ArrayList<Card> subset:getSubsets()){
            if (isFifteen(subset)){
                getPlayer().Score(2);
                getLogger().WriteToFile(header() + "2,fifteen," + canonical(subset));
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
            sum += Cribbage.cardValue(card);
            if (sum == FIFTEEN){
                return true;
            }else if(sum > FIFTEEN){
                return false;
            }
        }
        return false;
    }
}