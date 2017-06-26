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

    @SqlUpdate("insert into meal ( mealName, mealImage, mealRating, mealHelathValue, mealPreparationTime, mealEnergy, mealProtein, mealTotalFat, mealSaturated, mealTotalCarbohydrate, mealSugar, mealSodium) " +
            "values ( :mealName, :mealImage, :mealRating, :mealHelathValue, :mealPreparationTime, :mealEnergy, :mealProtein, :mealTotalFat, :mealSaturated, :mealTotalCarbohydrate, :mealSugar, :mealSodium")
    void newMeal(
            @Bind("mealName") String mealName,
            @Bind("mealImage") byte[] mealImage,
            @Bind("mealRating") float mealRating,
            @Bind("mealHelathValue") int mealHelathValue,
            @Bind("mealPreparationTime") Date mealPreparationTime,
            @Bind("mealEnergy") float mealEnergy,
            @Bind("mealProtein") float mealProtein,
            @Bind("mealTotalFat") float mealTotalFat,
            @Bind("mealSaturated") float mealSaturated,
            @Bind("mealTotalCarbohydrate") float mealTotalCarbohydrate,
            @Bind("mealSugar") float mealSugar,
            @Bind("mealSodium") float mealSodium);

    @SqlUpdate("delete from meal where mealId = :id")
    Meal delteMealById(@Bind("id") int id);
    //TODO: void update()

    public void close();
}
