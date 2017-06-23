package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Meal {
    private int mealId;

    private String mealName;

    private byte[] mealImage;

    private float mealRating;

    private int mealHelathValue;

    private Date mealPreparationTime;

    private Date offerDate;

    private float mealEnergy;

    private float mealProtein;

    private float mealTotalFat;

    private float mealSaturated;

    private float mealTotalCarbohydrate;

    private float mealSugar;

    private float mealSodium;

    private Ingredient[] mealIngredints;

    private Category[] mealCategories;

    private Rating[] mealRatings;

    public Meal(int mealId, String mealName, byte[] mealImage, float mealRating, int mealHelathValue, Date mealPreparationTime, Date offerDate, float mealEnergy, float mealProtein, float mealTotalFat, float mealSaturated, float mealTotalCarbohydrate, float mealSugar, float mealSodium, Ingredient[] mealIngredints, Category[] mealCategories, Rating[] mealRatings) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealImage = mealImage;
        this.mealRating = mealRating;
        this.mealHelathValue = mealHelathValue;
        this.mealPreparationTime = mealPreparationTime;
        this.offerDate = offerDate;
        this.mealEnergy = mealEnergy;
        this.mealProtein = mealProtein;
        this.mealTotalFat = mealTotalFat;
        this.mealSaturated = mealSaturated;
        this.mealTotalCarbohydrate = mealTotalCarbohydrate;
        this.mealSugar = mealSugar;
        this.mealSodium = mealSodium;
        this.mealIngredints = mealIngredints;
        this.mealCategories = mealCategories;
        this.mealRatings = mealRatings;
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

    public Ingredient[] getMealIngredints() {
        return mealIngredints;
    }

    public void setMealIngredints(Ingredient[] mealIngredints) {
        this.mealIngredints = mealIngredints;
    }

    public Category[] getMealCategories() {
        return mealCategories;
    }

    public void setMealCategories(Category[] mealCategories) {
        this.mealCategories = mealCategories;
    }

    public Rating[] getMealRatings() {
        return mealRatings;
    }

    public void setMealRatings(Rating[] mealRatings) {
        this.mealRatings = mealRatings;
    }
}
