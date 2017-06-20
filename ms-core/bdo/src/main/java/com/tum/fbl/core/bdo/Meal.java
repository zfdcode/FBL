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

}
