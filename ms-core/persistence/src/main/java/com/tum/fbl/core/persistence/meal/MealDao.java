package com.tum.fbl.core.persistence.meal;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(MealMapper.class)
public interface MealDao extends AutoCloseable{
    /**
     * gets an entry with a specified unique mealId from the Meal table in the database
     * @param id the unique ID of the meal
     * @return Meal object
     */
    @SqlQuery("select * from meal where mealId = :id")
    Meal findMealById(@Bind("id") int id);

    @SqlQuery("select * from meal where mealName = :name")
    Meal getMealByName(@Bind("name") int name);

    @SqlQuery("select * from meal where rating > :rating")
    Meal getMealByRating(@Bind("rating") int rating);

    @SqlQuery("select * from meal where energy < :energy")
    Meal getMealMaxCalories(@Bind("energy") int energy);

    /**
     * gets all meals offered on a specified date from the database
     * @param offerDate the specified date
     * @return List of Meal objects
     */
    @SqlQuery("select * from meal where offerDate = :offerDate)")
    List<Meal> getAllMealForDate(@Bind("offerDate") Date offerDate);

    @SqlQuery("select * from meal")
    List<Meal> getAllMeals();

    @SqlQuery("select m.mealId, m.mealName, m.image, m.rating, m.healthValue, m.preparationTime, m.offerDate, m.energy, m.protein, m.totalFat, m.saturated, m.totalCarbohydrate, m.sugar, m.sodium, m.price " +
            "from Meal m natural join (Select * from MealIngredient where ingredientId= :id)")
    List<Meal> getMealsByIngredient(@Bind("id") int id);

    @SqlQuery("select m.mealId, m.mealName, m.image, m.rating, m.healthValue, m.preparationTime, m.offerDate, m.energy, m.protein, m.totalFat, m.saturated, m.totalCarbohydrate, m.sugar, m.sodium, m.price " +
            "from Meal m natural join (Select * from MealIngredient where NOT(ingredientId= :id))")
    List<Meal> getMealsWithIngredientExeption(@Bind("id") int id);

    @SqlQuery("select m.mealId, m.mealName, m.image, m.rating, m.healthValue, m.preparationTime, m.offerDate, m.energy, m.protein, m.totalFat, m.saturated, m.totalCarbohydrate, m.sugar, m.sodium, m.price " +
            "from Meal m natural join (Select * from MealRestaurant where userId= :id)")
    List<Meal> getMealsByUser(@Bind("id") int id);

    @SqlQuery("select m.mealId, m.mealName, m.image, m.rating, m.healthValue, m.preparationTime, m.offerDate, m.energy, m.protein, m.totalFat, m.saturated, m.totalCarbohydrate, m.sugar, m.sodium, m.price " +
            "from Meal m where offerDate = :date natural join (Select * from MealRestaurant where userId= :id)")
    List<Meal> getMealsByUserAndDate(@Bind("date") Date date, @Bind("id") int id);

    @SqlQuery("select m.mealId, m.mealName, m.image, m.rating, m.healthValue, m.preparationTime, m.offerDate, m.energy, m.protein, m.totalFat, m.saturated, m.totalCarbohydrate, m.sugar, m.sodium, m.price " +
            "from Meal m where offerDate = :date natural join (Select * from MealCategory where categoryId= :id)")
    List<Meal> getMealsByCategoryAndDate(@Bind("date") Date date, @Bind("id") int id);

    @SqlQuery("select m.mealId, m.mealName, m.image, m.rating, m.healthValue, m.preparationTime, m.offerDate, m.energy, m.protein, m.totalFat, m.saturated, m.totalCarbohydrate, m.sugar, m.sodium, m.price " +
            "from Meal m natural join (Select * from Order where orderId= :id)")
    Meal getMealsByOrder(@Bind("id") int orderId);


    /**
     * inserts a new entry into the Meal table in the database
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
    @SqlUpdate("insert into meal ( mealName, image, rating, healthValue, preparationTime, offerDate, energy, protein, totalFat, saturated, totalCarbohydrate, sugar, sodium, price) " +
            "values ( :mealName, :image, :rating, :healthValue, :preparationTime, :offerDate, :energy, :protein, :totalFat, :saturated, :totalCarbohydrate, :sugar, :sodium, :price) ; SELECT LAST_INSERT_ID()")
    int newMeal(
            @Bind("mealName") String mealName,
            @Bind("image") String image,
            @Bind("rating") float rating,
            @Bind("healthValue") int healthValue,
            @Bind("preparationTime") Date preparationTime,
            @Bind("offerDate") Date offerDate,
            @Bind("energy") float energy,
            @Bind("protein") float protein,
            @Bind("totalFat") float totalFat,
            @Bind("saturated") float saturated,
            @Bind("totalCarbohydrate") float totalCarbohydrate,
            @Bind("sugar") float sugar,
            @Bind("sodium") float sodium,
            @Bind("price") float price);

    @SqlUpdate("insert into mealRestaurant (mealId, userId, date) values (:mealId, :userId, :date)")
    void newRestaurantMeal(@Bind("mealId") int mealId, @Bind("userId") int userId, @Bind("date") Date date);

    /**
     * deletes an entry with specified unique ID from the Meal table in the database
      * @param id the id of the entry that will be deleted
     */
    @SqlUpdate("delete from meal where mealId = :id")
    void deleteMealById(@Bind("id") int id);
    //TODO: void update()

    @SqlQuery("select * from Meal where :attributeName = :attributeId")
    List<Meal> findMealsByAttributte(@Bind("attributeName") String attributeName, @Bind("attributeId") int id);

    public void close();
}
