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

    /**
     * gets all meals offered on a specified date from the database
     * @param offerDate the specified date
     * @return List of Meal objects
     */
    @SqlQuery("select * from meal natural left join (select * from Offerdate where offerDate = :offerDate)")
    List<Meal> getAllMealForDate(@Bind("offerDate") Date offerDate);

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
