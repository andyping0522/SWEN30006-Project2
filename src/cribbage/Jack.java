package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class Jack extends IScoringRuleStrategy{
    private Card starter;

    public Jack(ArrayList<Card> set, Card starter) {
        super(set);
        this.starter = starter;
    }

    @Override
    public int getScore() {
        ArrayList<Card> cards = getSet();
        Card lastPlayed = cards.get(cards.size() - 1);
        if ((Cribbage.Rank)lastPlayed.getRank() == Cribbage.Rank.JACK &&
                (Cribbage.Suit)lastPlayed.getSuit() == (Cribbage.Suit)starter.getSuit()){
            return 1;
        }
        return 0;
    }
}