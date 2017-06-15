package com.tum.fbl.core.persistence.meal;

import java.util.Date;

public class Meal {

    private String mealId;

    private String mealName;

    private byte[] mealImage;

    private float mealRating;

    private int mealHelathValue;

    private Date mealPreparationTime;

    private float mealEnergy;

    private float mealProtein;

    private float mealTotalFat;

    private float mealSaturated;

    private float mealTotalCarbohydrate;

    private float mealSugar;

    private float mealSodium;

    public Meal(String mealId, String mealName, byte[] mealImage, float mealRating, int mealHelathValue, Date mealPreparationTime, float mealEnergy, float mealProtein, float mealTotalFat, float mealSaturated, float mealTotalCarbohydrate, float mealSugar, float mealSodium) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealImage = mealImage;
        this.mealRating = mealRating;
        this.mealHelathValue = mealHelathValue;
        this.mealPreparationTime = mealPreparationTime;
        this.mealEnergy = mealEnergy;
        this.mealProtein = mealProtein;
        this.mealTotalFat = mealTotalFat;
        this.mealSaturated = mealSaturated;
        this.mealTotalCarbohydrate = mealTotalCarbohydrate;
        this.mealSugar = mealSugar;
        this.mealSodium = mealSodium;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public byte[] getMealImage() {
        return mealImage;
    }

    public void setMealImage(byte[] mealImage) {
        this.mealImage = mealImage;
    }

    public float getMealRating() {
        return mealRating;
    }

    public void setMealRating(float mealRating) {
        this.mealRating = mealRating;
    }

    public int getMealHelathValue() {
        return mealHelathValue;
    }

    public void setMealHelathValue(int mealHelathValue) {
        this.mealHelathValue = mealHelathValue;
    }

    public Date getMealPreparationTime() {
        return mealPreparationTime;
    }

    public void setMealPreparationTime(Date mealPreparationTime) {
        this.mealPreparationTime = mealPreparationTime;
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