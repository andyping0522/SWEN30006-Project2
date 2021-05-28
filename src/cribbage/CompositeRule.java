package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public abstract class CompositeRule extends IScoringRuleStrategy{


    public CompositeRule(ArrayList<Card> set, IPlayer player) {
        super(set, player);


    }



    public abstract int getScore();
    protected abstract ArrayList<IScoringRuleStrategy> getStrategies();
}
