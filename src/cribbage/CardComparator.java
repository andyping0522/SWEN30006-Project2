package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.Comparator;

/* implement a comparator to allow card sorting based on card value */
public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card a, Card b){
        if (Cribbage.cardValue(a) > Cribbage.cardValue(b)){
            return -1;
        }else if(Cribbage.cardValue(a) < Cribbage.cardValue(b)){
            return 1;
        }else{
            return 0;
        }
    }
}
