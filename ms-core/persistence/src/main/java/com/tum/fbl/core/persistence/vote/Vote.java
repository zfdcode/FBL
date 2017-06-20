package com.tum.fbl.core.bdo;

public class Vote {
    private int voteId;

    private int ingredientId;

    private int votingId;

    private int userId;

    private String like;

    public Vote(int voteId, int ingredientId, int votingId, int userId, String like) {
        this.voteId = voteId;
        this.ingredientId = ingredientId;
        this.votingId = votingId;
        this.userId = userId;
        this.like = like;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getVotingId() {
        return votingId;
    }

    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}