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

    @SqlQuery("select * from meal where meal_id = :id")
    Meal findMealById(@Bind("id") String id);

    @SqlUpdate("insert into meal ( meal_name, meal_image, meal_rating, meal_health_value, meal_preparation_time, meal_energy, meal_protein, meal_total_fat, meal_saturated, meal_total_carbohydrate, meal_sugar, meal_sodium) values (:meal_name, :meal_image, :meal_rating, :meal_health_value, :meal_preparation_time, :fat meal_energy, :meal_protein, :meal_total_fat, :meal_saturated, :meal_total_carbohydrate, :meal_sugar, :meal_sodium)")
    void newMeal(
            @Bind("meal_name") String meal_name,
            @Bind("meal_image") byte[] meal_image,
            @Bind("meal_rating") float meal_rating,
            @Bind("meal_health_value") int meal_health_value,
            @Bind("meal_preparation_time") Date meal_preparation_time,
            @Bind("meal_energy") float meal_energy,
            @Bind("meal_protein") float meal_protein,
            @Bind("meal_total_fat") float meal_total_fat,
            @Bind("meal_saturated") float meal_saturated,
            @Bind("meal_total_carbohydrate") float meal_total_carbohydrate,
            @Bind("meal_sugar") float meal_sugar,
            @Bind("meal_sodium") float meal_sodium);
}
