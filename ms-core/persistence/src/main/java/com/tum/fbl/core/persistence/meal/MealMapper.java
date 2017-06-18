package com.tum.fbl.core.persistence.meal;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class MealMapper implements ResultSetMapper<Meal> {

    @Override
    public Meal map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Meal(
                r.getString("mealId"),
                r.getString("mealName"),
                r.getBytes("mealImage"),
                r.getFloat("mealRating"),
                r.getInt("mealHelathValue"),
                r.getDate("mealPreparationTime"),
                r.getFloat("mealEnergy"),
                r.getFloat("mealProtein"),
                r.getFloat("mealTotalFat"),
                r.getFloat("mealSaturated"),
                r.getFloat("mealTotalCarbohydrate"),
                r.getFloat("mealSugar"),
                r.getFloat("mealSodium"));
    }

}