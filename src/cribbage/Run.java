package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class Run extends IScoringRuleStrategy{
    public Run(ArrayList<Card> set) {
        super(set);
    }

    @Override
    public int getScore() {
        int result = 0;
        for (ArrayList<Card> subset:getSubsets()){
            if (isRun(subset)){
                result += subset.size();
            }
        }
        return result;
    }

    /**
     * Check whether given set of cards forms a run, set is sorted when passed in
     * @param cards
     * @return
     */
    private boolean isRun(ArrayList<Card> cards){
        int i;
        if (cards.size() < 3){
            // no run is formed when there's less than 3 cards
            return false;
        }
        i = cards.get(0).getValue();
        for (int j=1; j<cards.size(); j++){
            if (cards.get(j).getValue() - i != 1){
                return false;
            }
            i = cards.get(j).getValue();
        }
        return true;
    }
}