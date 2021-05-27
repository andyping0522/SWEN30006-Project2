package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class CompositeRuleShow extends CompositeRule{
    private Card starter;
    private ArrayList<IScoringRuleStrategy> strategies;
    public CompositeRuleShow(ArrayList<Card> set, Card starter) {
        super(set);
        this.starter = starter;
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
    protected ArrayList<IScoringRuleStrategy> getStrategies() {
        ArrayList<IScoringRuleStrategy> result = new ArrayList<IScoringRuleStrategy>();
        ArrayList<Card> list = getSet();
        list.add(starter);
        Run run = new Run(list);
        FifteenForShow fifteen = new FifteenForShow(list);
        Flush flush = new Flush(list);
        Jack jack = new Jack(getSet(), starter);
        PairForShow pair = new PairForShow(list);
        result.add(run);
        result.add(fifteen);
        result.add(flush);
        result.add(jack);
        result.add(pair);
        return result;

    }
}