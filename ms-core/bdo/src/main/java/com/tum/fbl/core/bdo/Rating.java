package com.tum.fbl.core.bdo;

/**
 * Created by zfngd on 2017/6/4.
 */
public class Rating {

    private int ratingId;

    private User user;

    private Meal meal;

    private float rate;

    public Rating(int ratingId, User user, Meal meal, float rate) {
        this.ratingId = ratingId;
        this.user = user;
        this.meal = meal;
        this.rate = rate;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
