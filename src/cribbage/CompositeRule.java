package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public abstract class CompositeRule extends IScoringRuleStrategy{


    public CompositeRule(ArrayList<Card> set, IPlayer player) {
        super(set, player);


    }



    public abstract int getScore(); // get total score from each strategy
    protected abstract ArrayList<IScoringRuleStrategy> getStrategies(); // get a list of strategies
}
