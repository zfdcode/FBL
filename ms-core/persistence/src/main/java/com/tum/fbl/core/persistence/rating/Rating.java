package com.tum.fbl.core.persistence.rating;

public class Rating {

    private String user_id;

    private String meal_id;

    private float rate;

    public Rating(String user_id, String meal_id, float rate) {
        this.user_id = user_id;
        this.meal_id = meal_id;
        this.rate = rate;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}