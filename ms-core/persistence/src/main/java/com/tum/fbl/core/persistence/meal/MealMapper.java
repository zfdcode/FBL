package com.tum.fbl.core.persistence.meal;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class MealMapper implements ResultSetMapper<Meal> {

    /**
     * Maps meal data stored in db to Meal.
     * @param index
     * @param r
     * @param ctx
     * @return Meal
     * @throws SQLException
     */
    @Override
    public Meal map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Meal(
                r.getInt("mealId"),
                r.getString("mealName"),
                r.getString("mealImage"),
                r.getFloat("mealRating"),
                r.getInt("mealHelathValue"),
                r.getDate("mealPreparationTime"),
                r.getDate("offerDate"),
                r.getFloat("mealEnergy"),
                r.getFloat("mealProtein"),
                r.getFloat("mealTotalFat"),
                r.getFloat("mealSaturated"),
                r.getFloat("mealTotalCarbohydrate"),
                r.getFloat("mealSugar"),
                r.getFloat("mealSodium"));
    }

}