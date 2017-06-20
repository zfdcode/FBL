package com.tum.fbl.core.persistence.rating;

public class Rating {

    private int ratingId;

    private int userId;

    private int mealId;

    private float rating;

    public Rating(int ratingId, int userId, int mealId, float rating) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.mealId = mealId;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}