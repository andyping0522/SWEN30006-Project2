package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class Flush extends IScoringRuleStrategy{
    private static final int FLUSH5 = 5;
    private static final int FLUSH4 = 4;
    public Flush(ArrayList<Card> set) {
        super(set);
    }

    @Override
    public int getScore() {
        int result = 0;
        ArrayList<Card> list = getSet();
        Cribbage.Suit suit = (Cribbage.Suit) list.get(0).getSuit();
        for (int i=1; i<4; i++){
            Cribbage.Suit currSuit = (Cribbage.Suit) list.get(i).getSuit();
            if (currSuit != suit){
                return 0;
            }
        }
        if (list.size() == 5){
            if ((Cribbage.Suit) list.get(5).getSuit() == suit){
                return FLUSH5;
            }else {
                return FLUSH4;
            }
        }else{
            return FLUSH4;
        }

    }
}