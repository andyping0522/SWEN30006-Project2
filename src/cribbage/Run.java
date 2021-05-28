package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public abstract class Run extends IScoringRuleStrategy{
    public Run(ArrayList<Card> set, IPlayer player) {
        super(set, player);
    }

    /**
     * Check whether given set of cards forms a run, set is sorted when passed in
     * @param cards
     * @return
     */
    protected boolean isRun(ArrayList<Card> cards){
        int i;
        if (cards.size() < 3){
            // no run is formed when there's less than 3 cards
            return false;
        }
        i = Cribbage.cardValue(cards.get(0));
        for (int j=1; j<cards.size(); j++){
            if (Cribbage.cardValue(cards.get(j)) - i != 1){
                return false;
            }
            i = Cribbage.cardValue(cards.get(j));
        }
        return true;
    }


}
