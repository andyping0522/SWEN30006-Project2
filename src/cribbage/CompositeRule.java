package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public abstract class CompositeRule extends IScoringRuleStrategy{


    public CompositeRule(ArrayList<Card> set) {
        super(set);


    }



    public abstract int getScore();
    protected abstract ArrayList<IScoringRuleStrategy> getStrategies();
}
