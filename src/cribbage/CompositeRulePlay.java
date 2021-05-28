package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class CompositeRulePlay extends CompositeRule{
    private ArrayList<Card> unsortedSet;
    private ArrayList<IScoringRuleStrategy> strategies;
    public CompositeRulePlay(ArrayList<Card> set, ArrayList<Card> unsortedSet, IPlayer player) {
        super(set, player);
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
        ArrayList<IScoringRuleStrategy> result = new ArrayList<>();

        RunForPlay run = new RunForPlay(getSet(), unsortedSet, getPlayer());
        PairForPlay pair = new PairForPlay(getSet(), unsortedSet, getPlayer());
        FifteenForPlay fifteenForPlay = new FifteenForPlay(getSet(), getPlayer());
        result.add(fifteenForPlay);
        result.add(run);
        result.add(pair);

        return result;
    }
}
