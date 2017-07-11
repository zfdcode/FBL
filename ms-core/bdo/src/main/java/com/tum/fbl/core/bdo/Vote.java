package com.tum.fbl.core.bdo;

/**
 * Documented by jie on 01.07.2017.
 */

public class Vote {
    private int voteId;

    private int votingIngItemId;

    private int userId;

    private String type;

    public Vote(){}

    public Vote(int voteId, int votingIngItemId, int userId, String type) {
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

    public int getVotingIngItemId() {
        return votingIngItemId;
    }

    public void setVotingIngItemId(int votingIngItemId) {
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

    public void setType(String type) {
        this.type = type;
    }
}