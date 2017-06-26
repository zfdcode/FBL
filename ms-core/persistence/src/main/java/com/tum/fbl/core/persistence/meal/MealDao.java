package com.tum.fbl.core.persistence.meal;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(MealMapper.class)
public interface MealDao extends AutoCloseable{

    @SqlQuery("select * from meal where mealId = :id")
    Meal findMealById(@Bind("id") int id);

    @SqlQuery("select * from meal where offerDate = :offerDate")
    Meal getAllMealForDate(@Bind("offerDate") Date offerDate);

    @SqlUpdate("insert into meal ( mealName, mealImage, mealRating, mealHelathValue, mealPreparationTime, offerDate, mealEnergy, mealProtein, mealTotalFat, mealSaturated, mealTotalCarbohydrate, mealSugar, mealSodium) " +
            "values ( :mealName, :mealImage, :mealRating, :mealHelathValue, :mealPreparationTime, offerDate, :mealEnergy, :mealProtein, :mealTotalFat, :mealSaturated, :mealTotalCarbohydrate, :mealSugar, :mealSodium")
    void newMeal(
            @Bind("mealName") String mealName,
            @Bind("mealImage") byte[] mealImage,
            @Bind("mealRating") float mealRating,
            @Bind("mealHelathValue") int mealHelathValue,
            @Bind("mealPreparationTime") Date mealPreparationTime,
            @Bind("offerDate") Date offerDate,
            @Bind("mealEnergy") float mealEnergy,
            @Bind("mealProtein") float mealProtein,
            @Bind("mealTotalFat") float mealTotalFat,
            @Bind("mealSaturated") float mealSaturated,
            @Bind("mealTotalCarbohydrate") float mealTotalCarbohydrate,
            @Bind("mealSugar") float mealSugar,
            @Bind("mealSodium") float mealSodium);

    @SqlUpdate("delete from meal where mealId = :id")
    Meal deleteMealById(@Bind("id") int id);

}
