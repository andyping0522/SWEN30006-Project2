package cribbage;
import ch.aplu.jcardgame.*;

import java.util.ArrayList;
public abstract class IScoringRuleStrategy {
    private int score;
    private ArrayList<Card> set;

    private ArrayList<ArrayList<Card>> subsets;
    public abstract int getScore();

    public IScoringRuleStrategy(ArrayList<Card> set) {
        this.set = set;
        this.subsets = subsets(set);

        this.score = 0;
    }

    public ArrayList<ArrayList<Card>> getSubsets() {
        return subsets;
    }



    public ArrayList<Card> getSet(){
        return this.set;
    }

    public int getSc(){
        return this.score;
    }

    public void addScore(int points){
        this.score += points;
    }

    /**
     * Generate all subsets of a given set of cards
     * @param set set of cards
     * @return the nested arraylist containing all subsets
     */
    protected ArrayList<ArrayList<Card>> subsets(ArrayList<Card> set){
        ArrayList<ArrayList<Card>> result = new ArrayList<ArrayList<Card>>();
        helper(result, new ArrayList<Card>(), set, 0);
        return result;
    }

    private void helper(ArrayList<ArrayList<Card>> res,
                        ArrayList<Card> subset,
                        ArrayList<Card> set,
                        int start){
        res.add(new ArrayList<Card>(subset));
        for (int i = start; i < set.size(); i++){
            subset.add(set.get(i)); // include current item
            helper(res, subset, set, i + 1); // explore further subsets
            subset.remove(subset.size() - 1); // remove to trigger backtracking
        }
    }
}
