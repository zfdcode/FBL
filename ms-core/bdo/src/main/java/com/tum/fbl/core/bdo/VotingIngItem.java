package com.tum.fbl.core.bdo;

/**
 * Created by MS on 10.07.2017.
 */
public class VotingIngItem {

    private int votingIngItemId;

    private int votingPeriodId;

    private boolean isIgnored;

    private int ingredientId;

    private Ingredient ingredient;

    private Vote[] votes;

    public VotingIngItem(int votingIngItemId, int votingPeriodId, boolean isIgnored, int ingredientId, Ingredient ingredient, Vote[] votes) {
        this.votingIngItemId = votingIngItemId;
        this.votingPeriodId = votingPeriodId;
        this.isIgnored = isIgnored;
        this.ingredientId = ingredientId;
        this.ingredient = ingredient;
        this.votes = votes;
    }

    public int getVotingIngItemId() {
        return votingIngItemId;
    }

    public void setVotingIngItemId(int votingIngItemId) {
        this.votingIngItemId = votingIngItemId;
    }

    public int getVotingPeriodId() {
        return votingPeriodId;
    }

    public void setVotingPeriodId(int votingPeriodId) {
        this.votingPeriodId = votingPeriodId;
    }

    public boolean isIgnored() {
        return isIgnored;
    }

    public void setIgnored(boolean ignored) {
        isIgnored = ignored;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Vote[] getVotes() {
        return votes;
    }

    public void setVotes(Vote[] votes) {
        this.votes = votes;
    }


}
