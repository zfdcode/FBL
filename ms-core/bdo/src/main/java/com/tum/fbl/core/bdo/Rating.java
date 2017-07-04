package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by zfngd on 2017/6/4.
 * Documented by jie on 27.06.2017.
 */
public class Rating {

    private int ratingId;

    private User user;

    private Meal meal;

    private boolean rate;

    private Date ratingTimestamp;

    /**
     * Constructs Rating that is made by the user for the meal
     * @param ratingId unique ID of the rating action
     * @param user user who makes the rating
     * @param meal meal that is rated
     * @param rate marks of the rate
     */
    public Rating(int ratingId, User user, Meal meal, float rate) {
        this.ratingId = ratingId;
        this.user = user;
        this.meal = meal;
        this.rate = rate;
        this.ratingTimestamp = ratingTimestamp;
    }

    /**
     * Gets RatingId.
     * @return ratingId unique ID of the rating action
     */
    public int getRatingId() { return ratingId; }

    /**
     * Sets RatingId.
     * @param ratingId unique ID of the rating action
     */
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    /**
     * Gets User.
     * @return user user who makes the rating
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets User.
     * @param user user who makes the rating
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets Meal.
     * @return meal meal that is rated
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * Sets Meal.
     * @param meal meal that is rated
     */
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    /**
     * Gets Rate.
     * @return rate marks of the rate
     */
    public float getRate() {
        return rate;
    }

    /**
     * Sets Rate.
     * @param rate marks of the rate
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    public Date getRatingTimestamp() {
        return ratingTimestamp;
    }

    public void setRatingTimestamp(Date ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
    }
}
