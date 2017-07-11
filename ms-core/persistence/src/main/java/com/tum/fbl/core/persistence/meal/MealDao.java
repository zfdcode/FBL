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
    @SqlUpdate("insert into meal ( mealName, mealImage, mealRating, mealHelathValue, mealPreparationTime, offerDate, mealEnergy, mealProtein, mealTotalFat, mealSaturated, mealTotalCarbohydrate, mealSugar, mealSodium) " +
            "values ( :mealName, :mealImage, :mealRating, :mealHelathValue, :mealPreparationTime, offerDate, :mealEnergy, :mealProtein, :mealTotalFat, :mealSaturated, :mealTotalCarbohydrate, :mealSugar, :mealSodium")
    void newMeal(
            @Bind("mealName") String mealName,
            @Bind("mealImage") byte[] mealImage,
            @Bind("mealRating") float mealRating,
            @Bind("mealHelathValue") int mealHealthValue,
            @Bind("mealPreparationTime") Date mealPreparationTime,
            @Bind("offerDate") Date offerDate,
            @Bind("mealEnergy") float mealEnergy,
            @Bind("mealProtein") float mealProtein,
            @Bind("mealTotalFat") float mealTotalFat,
            @Bind("mealSaturated") float mealSaturated,
            @Bind("mealTotalCarbohydrate") float mealTotalCarbohydrate,
            @Bind("mealSugar") float mealSugar,
            @Bind("mealSodium") float mealSodium);

    /**
     * deletes an entry with specified unique ID from the Meal table in the database
      * @param id the id of the entry that will be deleted
     * @return the deleted Meal object
     */
    @SqlUpdate("delete from meal where mealId = :id")
    Meal deleteMealById(@Bind("id") int id);
    //TODO: void update()

    public void close();
}
