package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class CompositeRuleFactory {
    private static CompositeRuleFactory instance;

    public static CompositeRuleFactory getInstance(){
        if (instance == null){
            instance = new CompositeRuleFactory();

        }
        return instance;
    }

    public CompositeRulePlay getCompositeRulePlay(ArrayList<Card> set, ArrayList<Card> unsortedSet){
        return new CompositeRulePlay(set, unsortedSet);
    }

    public CompositeRuleShow getCompositeRuleShow(ArrayList<Card> set, Card starter){
        return new CompositeRuleShow(set,starter);
    }
}
