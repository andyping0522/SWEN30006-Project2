package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class CompositeRuleShow extends CompositeRule{
    private Card starter;
    private ArrayList<IScoringRuleStrategy> strategies;
    public CompositeRuleShow(ArrayList<Card> set, Card starter, IPlayer player) {
        super(set, player);
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
        RunForShow run = new RunForShow(list, getPlayer());
        FifteenForShow fifteen = new FifteenForShow(list, getPlayer());
        Flush flush = new Flush(list, getPlayer());
        Jack jack = new Jack(getSet(), starter, getPlayer());
        PairForShow pair = new PairForShow(list, getPlayer());
        result.add(fifteen);
        result.add(run);
        result.add(pair);
        result.add(flush);
        result.add(jack);

        return result;

    }
}