package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;


public class RunForShow extends Run{
    public RunForShow(ArrayList<Card> set, IPlayer player) {
        super(set, player);
    }

    @Override
    public int getScore() {
        int result = 0;
        for (ArrayList<Card> subset:getSubsets()){
            if (isRun(subset)){
                getPlayer().Score(subset.size());
                getLogger().WriteToFile(header() + subset.size() + ",run," + canonical(subset));
                result += subset.size();
            }
        }
        return result;
    }



}