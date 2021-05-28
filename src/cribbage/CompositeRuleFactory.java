package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class CompositeRuleFactory {
    // create a singleton
    private static CompositeRuleFactory instance;

    public static CompositeRuleFactory getInstance(){
        if (instance == null){
            instance = new CompositeRuleFactory();

        }
        return instance;
    }

    public CompositeRulePlay getCompositeRulePlay(ArrayList<Card> set, ArrayList<Card> unsortedSet, IPlayer player){
        return new CompositeRulePlay(set, unsortedSet, player);
    }

    public CompositeRuleShow getCompositeRuleShow(ArrayList<Card> set, Card starter, IPlayer player){
        return new CompositeRuleShow(set,starter, player);
    }
}
