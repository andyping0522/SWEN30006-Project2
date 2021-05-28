package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class RunForPlay extends Run{
    private ArrayList<Card> unsortedSet;
    public RunForPlay(ArrayList<Card> set, ArrayList<Card> unsortedSet, IPlayer player) {
        super(set, player);
        this.unsortedSet = unsortedSet;
    }

    @Override
    /**
     * Start with entire segment to see if a run is formed, progress one element backwards each time
     */
    public int getScore() {
        ;
        for (int start=0; start < unsortedSet.size(); start ++){
            ArrayList<Card> subset = new ArrayList<Card>(unsortedSet.subList(start, getSet().size()));
            if (subset.size() < 3){
                return 0;
            }
            subset.sort(new CardComparator());
            if (isRun(subset)){
                getPlayer().Score(subset.size());
                getLogger().WriteToFile(header() +subset.size()+",run,"+ canonical(subset)+ "\n");
                return subset.size();
            }
            start ++;
        }
        return 0;
    }



}
