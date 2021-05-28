package cribbage;
import ch.aplu.jcardgame.*;

import java.util.ArrayList;
public abstract class IScoringRuleStrategy {

    private ArrayList<Card> set;
    private MyLogger logger;
    private IPlayer player;

    private ArrayList<ArrayList<Card>> subsets;
    public abstract int getScore();


    public IPlayer getPlayer() {
        return player;
    }

    public IScoringRuleStrategy(ArrayList<Card> set, IPlayer player) {
        this.set = set;
        this.subsets = subsets(set);
        this.player = player;
        this.logger = new MyLogger();

    }

    public ArrayList<ArrayList<Card>> getSubsets() {
        return subsets;
    }

    public ArrayList<Card> getSet(){
        return this.set;
    }

    public MyLogger getLogger() {
        return logger;
    }

    protected String header(){
        return ("score,P"+ player.id +"," +player.score + ",");
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
        res.add(new ArrayList<>(subset));
        for (int i = start; i < set.size(); i++){
            subset.add(set.get(i)); // include current item
            helper(res, subset, set, i + 1); // explore further subsets
            subset.remove(subset.size() - 1); // remove to trigger backtracking
        }
    }

    protected String canonical(ArrayList<Card> cards){
        String result = "[";
        for (int i=0; i<cards.size(); i++){
            result += (canonical(cards.get(i)));
            if (i != cards.size() - 1){
                result += ",";
            }
        }
        result += "]";
        return result;
    }

    protected String canonical(Card c) {
        return canonical((Cribbage.Rank) c.getRank()) + canonical((Cribbage.Suit) c.getSuit());

    }

    String canonical(Cribbage.Suit s) { return s.toString().substring(0, 1); }

    String canonical(Cribbage.Rank r) {
        switch (r) {
            case ACE:case KING:case QUEEN:case JACK:case TEN:
                return r.toString().substring(0, 1);
            default:
                return String.valueOf(r.value);
        }
    }
}
