package com.tum.fbl.core.persistence.rating;

public class Rating {

    private String userId;

    private String mealId;

    private float rate;

    public Rating(String userId, String mealId, float rate) {
        this.userId = userId;
        this.mealId = mealId;
        this.rate = rate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}