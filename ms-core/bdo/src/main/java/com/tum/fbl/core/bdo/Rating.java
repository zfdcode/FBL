package com.tum.fbl.core.bdo;

/**
 * Created by zfngd on 2017/6/4.
 */
public class Rating {

    private int user_id;

    private int meal_id;

    private float rate;

    public Rating(int user_id, int meal_id, float rate) {
        this.user_id = user_id;
        this.meal_id = meal_id;
        this.rate = rate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
