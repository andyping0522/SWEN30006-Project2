package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;


public class RunForShow extends Run{
    public RunForShow(ArrayList<Card> set) {
        super(set);
    }

    @Override
    public int getScore() {
        int result = 0;
        for (ArrayList<Card> subset:getSubsets()){
            if (isRun(subset)){
                result += subset.size();
            }
        }
        return result;
    }



}