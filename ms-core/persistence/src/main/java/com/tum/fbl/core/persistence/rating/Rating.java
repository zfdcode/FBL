package com.tum.fbl.core.persistence.rating;

import java.util.Date;

public class Rating {

    private int ratingId;

    private int userId;

    private int mealId;

    private Date ratingTimestamp;

    private boolean rating;

    /**
     *
     * @param ratingId the rating's unique ID
     * @param userId the unique ID of the user who posted the voting
     * @param mealId the unique ID of the meal that has been rated
     * @param ratingTimestamp timestamp when the rating was posted
     * @param rating the actual rating
     */
    public Rating(int ratingId, int userId, int mealId, Date ratingTimestamp, boolean rating) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.mealId = mealId;
        this.ratingTimestamp = ratingTimestamp;
        this.rating = rating;
    }

    /**
     * Gets ratingId
     * @return rating Id
     */
    public int getRatingId() {
        return ratingId;
    }

    /**
     * Sets ratingId
     * @param ratingId
     */
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    /**
     * Gets userId
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets userId
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets mealId
     * @return
     */
    public int getMealId() {
        return mealId;
    }

    /**
     * Sets mealId
     * @param mealId
     */
    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    /**
     * Gets ratingTimestamp
     * @return ratingTimestamp
     */
    public Date getRatingTimestamp() {
        return ratingTimestamp;
    }

    /**
     * Sets ratingTimestamp
     * @param ratingTimestamp
     */
    public void setRatingTimestamp(Date ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
    }

    /**
     * gets rating
     * @return rating
     */
    public boolean isRating() {
        return rating;
    }

    /**
     * sets rating
     * @param rating
     */
    public void setRating(boolean rating) {
        this.rating = rating;
    }
}