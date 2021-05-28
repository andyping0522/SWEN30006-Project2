package cribbage;

import ch.aplu.jcardgame.Card;

import java.util.ArrayList;

public class PairForPlay extends IScoringRuleStrategy{
    private ArrayList<Card> unsortedSet;

    public PairForPlay(ArrayList<Card> set, ArrayList<Card> unsortedSet, IPlayer player) {
        super(set, player);
        this.unsortedSet = unsortedSet;
    }

    @Override
    public int getScore() {
        int result = 0;
        ArrayList<Card> candidates = new ArrayList<>();
        if (unsortedSet.size() < 2){
            return 0;
        }
        Cribbage.Rank required = (Cribbage.Rank) unsortedSet.get(unsortedSet.size() - 1).getRank();
        for (int j = unsortedSet.size() - 2; j >= 0; j--){
            if (unsortedSet.get(j).getRank() != required){
                break;
            }else{
                candidates.add(0, unsortedSet.get(j));
                result ++;
            }
        }
        if (result > 0){
            getPlayer().Score(result*2);
            getLogger().WriteToFile(header() + result*2 + ",pair,"+ canonical(candidates)+ "\n");
        }
        return result * 2;
    }
}
