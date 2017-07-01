package com.tum.fbl.core.bdo;

/**
 * Documented by jie on 01.07.2017.
 */

public class Vote {
    private int voteId;

    private int ingredientId;

    private int votingId;

    private User user;

    private String like;

    public Vote(int voteId, int ingredientId, int votingId, User user, String like) {
        this.voteId = voteId;
        this.ingredientId = ingredientId;
        this.votingId = votingId;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}