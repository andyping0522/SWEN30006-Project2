package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class CompositeRulePlay extends CompositeRule{
    private ArrayList<Card> unsortedSet;
    private ArrayList<IScoringRuleStrategy> strategies;
    public CompositeRulePlay(ArrayList<Card> set, ArrayList<Card> unsortedSet) {
        super(set);
        this.unsortedSet = unsortedSet;
        this.strategies = getStrategies();
    }

    @Override
    public int getScore() {
        int result = 0;
        for (IScoringRuleStrategy strategy:strategies){
            result += strategy.getScore();
        }
        return result;
    }

    @Override
    protected ArrayList<IScoringRuleStrategy> getStrategies(){
        ArrayList<IScoringRuleStrategy> result = new ArrayList<IScoringRuleStrategy>();
        Run run = new Run(getSet());
        PairForPlay pair = new PairForPlay(getSet(), unsortedSet);
        FifteenForPlay fifteenForPlay = new FifteenForPlay(getSet());
        result.add(run);
        result.add(pair);
        result.add(fifteenForPlay);
        return result;
    }
}