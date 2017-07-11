package com.tum.fbl.core.persistence.meal;

import java.util.Date;

public class Meal {

    private int mealId;

    private String mealName;

    private String mealImage;

    private float mealRating;

    private int mealHealthValue;

    private Date mealPreparationTime;

    private Date offerDate;

    private float mealEnergy;

    private float mealProtein;

    private float mealTotalFat;

    private float mealSaturated;

    private float mealTotalCarbohydrate;

    private float mealSugar;

    private float mealSodium;

    public Meal(int mealId, String mealName, String mealImage, float mealRating, int mealHealthValue, Date mealPreparationTime, float mealEnergy, float mealProtein, float mealTotalFat, float mealSaturated, float mealTotalCarbohydrate, float mealSugar, float mealSodium) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealImage = mealImage;
        this.mealRating = mealRating;
        this.mealHealthValue = mealHealthValue;
        this.mealPreparationTime = mealPreparationTime;
        this.offerDate = offerDate;
        this.mealEnergy = mealEnergy;
        this.mealProtein = mealProtein;
        this.mealTotalFat = mealTotalFat;
        this.mealSaturated = mealSaturated;
        this.mealTotalCarbohydrate = mealTotalCarbohydrate;
        this.mealSugar = mealSugar;
        this.mealSodium = mealSodium;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImage() {
        return mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    public float getMealRating() {
        return mealRating;
    }

    public void setMealRating(float mealRating) {
        this.mealRating = mealRating;
    }

    public int getMealHealthValue() {
        return mealHealthValue;
    }

    public void setMealHelathValue(int mealHelathValue) {
        this.mealHealthValue = mealHelathValue;
    }

    public Date getMealPreparationTime() {
        return mealPreparationTime;
    }

    public void setMealPreparationTime(Date mealPreparationTime) {
        this.mealPreparationTime = mealPreparationTime;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public float getMealEnergy() {
        return mealEnergy;
    }

    public void setMealEnergy(float mealEnergy) {
        this.mealEnergy = mealEnergy;
    }

    public float getMealProtein() {
        return mealProtein;
    }

    public void setMealProtein(float mealProtein) {
        this.mealProtein = mealProtein;
    }

    public float getMealTotalFat() {
        return mealTotalFat;
    }

    public void setMealTotalFat(float mealTotalFat) {
        this.mealTotalFat = mealTotalFat;
    }

    public float getMealSaturated() {
        return mealSaturated;
    }

    public void setMealSaturated(float mealSaturated) {
        this.mealSaturated = mealSaturated;
    }

    public float getMealTotalCarbohydrate() {
        return mealTotalCarbohydrate;
    }

    public void setMealTotalCarbohydrate(float mealTotalCarbohydrate) {
        this.mealTotalCarbohydrate = mealTotalCarbohydrate;
    }

    public float getMealSugar() {
        return mealSugar;
    }

    public void setMealSugar(float mealSugar) {
        this.mealSugar = mealSugar;
    }

    public float getMealSodium() {
        return mealSodium;
    }

    public void setMealSodium(float mealSodium) {
        this.mealSodium = mealSodium;
    }
}