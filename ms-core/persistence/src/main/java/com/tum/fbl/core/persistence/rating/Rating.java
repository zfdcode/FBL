package com.tum.fbl.core.persistence.rating;

public class Rating {

    private int ratingId;

    private int userId;

    private int mealId;

    private Date ratingTimestamp

    private boolean rating;

    public Rating(int ratingId, int userId, int mealId, Date ratingTimestamp, boolean rating) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.mealId = mealId;
        this.ratingTimestamp = ratingTimestamp;
        this.rating = rating;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public Date getRatingTimestamp() {
        return ratingTimestamp;
    }

    public void setRatingTimestamp(Date ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}