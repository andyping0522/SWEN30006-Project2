package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class FifteenForPlay extends IScoringRuleStrategy{
    public FifteenForPlay(ArrayList<Card> set, IPlayer player) {
        super(set, player);

    }

    @Override
    public int getScore() {
        int sum = 0;
        for (Card card:getSet()){
            // sum up current round set
            sum += Cribbage.cardValue(card);
            if (sum > 15){
                return 0;
            }
        }
        if (sum == 15){
            getPlayer().Score(2);
            getLogger().WriteToFile(header()+"2,fifteen,"+ canonical(getSet()));
            return 2;
        }else{
            return 0;
        }

    }
}