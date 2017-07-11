package com.tum.fbl.core.persistence.vote;

public class Vote {
    private int voteId;

    private int votingIngItemId;

    private int userId;

    private String type;

    /**
     *
     * @param voteId the vote's unique ID
     * @param votingIngItemId ID of the votingIngItem
     * @param userId the user's unique ID
     * @param type the type
     */
    public Vote(int voteId, int votingIngItemId, int userId, String type ) {
        this.voteId = voteId;
        this.votingIngItemId = votingIngItemId;
        this.userId = userId;
        this.type = type;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getvotingIngItemId() {
        return votingIngItemId;
    }

    public void setvotingIngItemId(int ingredientId) {
        this.votingIngItemId = votingIngItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String like) {
        this.type = type;
    }
}