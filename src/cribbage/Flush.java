package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class Flush extends IScoringRuleStrategy{
    private static final int FLUSH5 = 5;
    private static final int FLUSH4 = 4;
    public Flush(ArrayList<Card> set, IPlayer player) {
        super(set,player);
    }

    @Override
    public int getScore() {
        int result = 0;
        ArrayList<Card> list = getSet();
        Cribbage.Suit suit = (Cribbage.Suit) list.get(0).getSuit();
        for (int i=1; i<4; i++){
            //System.out.println(i);
            Cribbage.Suit currSuit = (Cribbage.Suit) list.get(i).getSuit();
            if (currSuit != suit){
                return 0;
            }
        }

        // check fifth element(the starter card)
        if (list.get(4).getSuit() == suit){
            getPlayer().Score(FLUSH5);
            getLogger().WriteToFile(header() + FLUSH5+ ",flush," +canonical(list)+ "\n");
            return FLUSH5;

        } else {
            getPlayer().Score(FLUSH4);
            getLogger().WriteToFile(header() + FLUSH4+ ",flush," +canonical(list)+ "\n");
            return FLUSH4;

        }
    }
}