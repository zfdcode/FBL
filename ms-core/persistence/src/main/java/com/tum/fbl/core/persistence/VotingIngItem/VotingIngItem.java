package com.tum.fbl.core.persistence.VotingIngItem;

import java.util.Date;

public class VotingIngItem {
    private int votingIngItemId;

    private int votingPeriodId;

    private boolean isIgnored;

    private int ingredientId;

    /**
     *
     * @param votingIngItemId the unique ID of the votingIngItem
     * @param votingPeriodId the unique ID of the voting period
     * @param isIgnored true if the voting is ignored, false otherwise
     * @param ingredientId the ingredient's unique ID
     */
    public VotingIngItem(int votingIngItemId, int votingPeriodId, boolean isIgnored, int ingredientId) {
        this.votingIngItemId = votingIngItemId;
        this.votingPeriodId = votingPeriodId;
        this.isIgnored = isIgnored;
        this.ingredientId = ingredientId;
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

    public Boolean getIsIgnored() {
        return isIgnored;
    }

    public void setIsIgnored(Boolean isIgnored) {
        this.isIgnored = isIgnored;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

}
