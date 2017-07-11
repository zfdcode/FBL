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

    /**
     *
     * @param mealId
     * @param mealName
     * @param mealImage
     * @param mealRating
     * @param mealHealthValue
     * @param mealPreparationTime
     * @param offerDate
     * @param mealEnergy
     * @param mealProtein
     * @param mealTotalFat
     * @param mealSaturated
     * @param mealTotalCarbohydrate
     * @param mealSugar
     * @param mealSodium
     */
    public Meal(int mealId, String mealName, String mealImage, float mealRating, int mealHealthValue, Date mealPreparationTime, Date offerDate, float mealEnergy, float mealProtein, float mealTotalFat, float mealSaturated, float mealTotalCarbohydrate, float mealSugar, float mealSodium) {
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

    /**
     * Gets the mealId
     * @return mealId
     */
    public int getMealId() {
        return mealId;
    }

    /**
     * Sets the mealId
     * @param mealId
     */
    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    /**
     * Gets the mealName
     * @return mealName
     */
    public String getMealName() {
        return mealName;
    }

    /**
     * Sets the mealName
     * @param mealName
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * Gets the mealImage URL
     * @return URL to mealImage
     */
    public String getMealImage() {
        return mealImage;
    }

    /**
     * Sets the mealImage URL
     * @param mealImage
     */
    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    /**
     * Gets the mealRating
     * @return mealRating
     */
    public float getMealRating() {
        return mealRating;
    }

    /**
     * Sets the mealRating
     * @param mealRating
     */
    public void setMealRating(float mealRating) {
        this.mealRating = mealRating;
    }

    /**
     * Gets the mealHealthValue
     * @return mealHealthValue
     */
    public int getMealHealthValue() {
        return mealHealthValue;
    }

    /**
     * Sets the mealHealthValue
     * @param mealHealthValue
     */
    public void setMealHelathValue(int mealHealthValue) {
        this.mealHealthValue = mealHealthValue;
    }

    /**
     * Gets the mealPreparationTime
     * @return mealPreparationTime
     */
    public Date getMealPreparationTime() {
        return mealPreparationTime;
    }

    /**
     * Sets the mealPreparationTime
     * @param mealPreparationTime
     */
    public void setMealPreparationTime(Date mealPreparationTime) {
        this.mealPreparationTime = mealPreparationTime;
    }

    /**
     * Gets the offerDate
     * @return offerDate
     */
    public Date getOfferDate() {
        return offerDate;
    }

    /**
     * Sets the offerDate
     * @param offerDate
     */
    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    /**
     * Gets the mealEnergy
     * @return mealEnergy
     */
    public float getMealEnergy() {
        return mealEnergy;
    }

    /**
     * Sets the mealEnergy
     * @param mealEnergy
     */
    public void setMealEnergy(float mealEnergy) {
        this.mealEnergy = mealEnergy;
    }

    /**
     * Gets the mealProtein
     * @return mealProtein
     */
    public float getMealProtein() {
        return mealProtein;
    }

    /**
     * Sets the mealProtein
     * @param mealProtein
     */
    public void setMealProtein(float mealProtein) {
        this.mealProtein = mealProtein;
    }

    /**
     * Gets the mealTotalFat
     * @return mealTotalFat
     */
    public float getMealTotalFat() {
        return mealTotalFat;
    }

    /**
     * Sets the mealTotalFat
     * @param mealTotalFat
     */
    public void setMealTotalFat(float mealTotalFat) {
        this.mealTotalFat = mealTotalFat;
    }

    /**
     * Gets mealSaturated
     * @return mealSaturated
     */
    public float getMealSaturated() {
        return mealSaturated;
    }

    /**
     * Sets mealSaturated
     * @param mealSaturated
     */
    public void setMealSaturated(float mealSaturated) {
        this.mealSaturated = mealSaturated;
    }

    /**
     * Gets mealTotalCarbohydrates
     * @return mealTotalCarbohydrate
     */
    public float getMealTotalCarbohydrate() {
        return mealTotalCarbohydrate;
    }

    /**
     * Sets mealTotalCarbohydrates
     * @param mealTotalCarbohydrate
     */
    public void setMealTotalCarbohydrate(float mealTotalCarbohydrate) {
        this.mealTotalCarbohydrate = mealTotalCarbohydrate;
    }

    /**
     * Gets mealSugar
     * @return mealSugar
     */
    public float getMealSugar() {
        return mealSugar;
    }

    /**
     * Sets mealSugar
     * @param mealSugar
     */
    public void setMealSugar(float mealSugar) {
        this.mealSugar = mealSugar;
    }

    /**
     * Gets mealSodium
     * @return mealSodium
     */
    public float getMealSodium() {
        return mealSodium;
    }

    /**
     * Sets mealSodium
     * @param mealSodium
     */
    public void setMealSodium(float mealSodium) {
        this.mealSodium = mealSodium;
    }
}