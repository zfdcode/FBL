package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Meal {

    private int mealId;

    private String mealName;

    private String url;

    private float mealRating;

    private int mealHealthValue;

    private Date mealPreparationTime;

    private Date[] offerDates;

    private float mealEnergy;

    private float mealProtein;

    private float mealTotalFat;

    private float mealSaturated;

    private float mealTotalCarbohydrate;

    private float mealSugar;

    private float mealSodium;

    private Ingredient[] mealIngredients;

    private Category[] mealCategories;

    private Rating[] mealRatings;

    private Restaurant mealRestaurant;

    public Meal (){

    }


    public Meal(int mealId, String mealName, String url, float mealRating, int mealHealthValue, Date mealPreparationTime, Date[] offerDates, float mealEnergy, float mealProtein, float mealTotalFat, float mealSaturated, float mealTotalCarbohydrate, float mealSugar, float mealSodium, Ingredient[] mealIngredients, Category[] mealCategories, Rating[] mealRatings, Restaurant mealRestaurant) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.url = url;
        this.mealRating = mealRating;
        this.mealHealthValue = mealHealthValue;
        this.mealPreparationTime = mealPreparationTime;
        this.offerDates = offerDates;
        this.mealEnergy = mealEnergy;
        this.mealProtein = mealProtein;
        this.mealTotalFat = mealTotalFat;
        this.mealSaturated = mealSaturated;
        this.mealTotalCarbohydrate = mealTotalCarbohydrate;
        this.mealSugar = mealSugar;
        this.mealSodium = mealSodium;
        this.mealIngredients = mealIngredients;
        this.mealCategories = mealCategories;
        this.mealRatings = mealRatings;
        this.mealRestaurant = mealRestaurant;
    }




    public Meal(com.tum.fbl.core.persistence.meal.Meal meal){
        this.mealId = meal.getMealId();
        this.mealName = meal.getMealName();
        this.url = meal.getMealImage();
        this.mealRating = meal.getMealRating();
        this.mealHealthValue = meal.getMealHealthValue();
        this.mealPreparationTime = meal.getMealPreparationTime();
        this.offerDates = new Date[0];
        this.mealEnergy = meal.getMealEnergy();
        this.mealProtein = meal.getMealProtein();
        this.mealTotalFat = meal.getMealTotalFat();
        this.mealSaturated = meal.getMealSaturated();
        this.mealTotalCarbohydrate = meal.getMealTotalCarbohydrate();
        this.mealSugar = meal.getMealSugar();
        this.mealSodium = meal.getMealSodium();
        this.mealIngredients = new Ingredient[0];
        this.mealCategories = new Category[0];
        this.mealRatings = new Rating[0];
        this.mealRestaurant = new Restaurant(0,null,null,null,
                null,null,0,0,null,
                null,null,null,
                null,null,null);

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setMealHealthValue(int mealHealthValue) {
        this.mealHealthValue = mealHealthValue;
    }

    public Date getMealPreparationTime() {
        return mealPreparationTime;
    }

    public void setMealPreparationTime(Date mealPreparationTime) {
        this.mealPreparationTime = mealPreparationTime;
    }

    public Date[] getOfferDates() {
        return offerDates;
    }

    public void setOfferDates(Date[] offerDates) {
        this.offerDates = offerDates;
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

    public Ingredient[] getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(Ingredient[] mealIngredients) {
        this.mealIngredients = mealIngredients;
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

    public Restaurant getMealRestaurant() {
        return mealRestaurant;
    }

    public void setMealRestaurant(Restaurant mealRestaurant) {
        this.mealRestaurant = mealRestaurant;
    }
}
