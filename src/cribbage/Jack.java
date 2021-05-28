package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class Jack extends IScoringRuleStrategy{
    private Card starter;

    public Jack(ArrayList<Card> set, Card starter, IPlayer player) {
        super(set, player);
        this.starter = starter;
    }

    @Override
    public int getScore() {
        ArrayList<Card> cards = getSet();
        int i = cards.size() - 1, result = 0;
        cards.remove(i);
        ArrayList<Card> candidates = new ArrayList<>();
        for (Card card:cards){
            if (card.getRank() == Cribbage.Rank.JACK &&
                card.getSuit() == starter.getSuit()){
                result ++;
                candidates.add(card);

            }
        }
        if (result > 0){
            getPlayer().Score(result);
            getLogger().WriteToFile(header()+ result +",jack,"+ canonical(candidates)+ "\n");
        }

        return 0;
    }
}