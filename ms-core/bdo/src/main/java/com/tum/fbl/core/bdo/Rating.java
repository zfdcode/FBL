package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by zfngd on 2017/6/4.
 */
public class Rating {

    private int ratingId;

    private User user;

    private Meal meal;

    private boolean rate;

    private Date ratingTimestamp;

    public Rating(int ratingId, User user, Meal meal, boolean rate, Date ratingTimestamp) {
        this.ratingId = ratingId;
        this.user = user;
        this.meal = meal;
        this.rate = rate;
        this.ratingTimestamp = ratingTimestamp;
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

    public boolean isRate() {
        return rate;
    }

    public void setRate(boolean rate) {
        this.rate = rate;
    }

    public Date getRatingTimestamp() {
        return ratingTimestamp;
    }

    public void setRatingTimestamp(Date ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
    }
}
