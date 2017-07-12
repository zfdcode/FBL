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
                r.getString("Image"),
                r.getFloat("Rating"),
                r.getInt("HealthValue"),
                r.getDate("PreparationTime"),
                r.getDate("offerDate"),
                r.getFloat("Energy"),
                r.getFloat("Protein"),
                r.getFloat("TotalFat"),
                r.getFloat("Saturated"),
                r.getFloat("TotalCarbohydrate"),
                r.getFloat("Sugar"),
                r.getFloat("Sodium"),
                r.getFloat("price"));
    }

}