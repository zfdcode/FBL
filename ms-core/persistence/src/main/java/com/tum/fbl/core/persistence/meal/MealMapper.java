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
                r.getString("meal_id"),
                r.getString("meal_name"),
                r.getBytes("meal_image"),
                r.getFloat("meal_rating"),
                r.getInt("meal_health_value"),
                r.getDate("meal_preparation_time"),
                r.getFloat("meal_energy"),
                r.getFloat("meal_protein"),
                r.getFloat("meal_total_fat"),
                r.getFloat("meal_saturated"),
                r.getFloat("meal_total_carbohydrate"),
                r.getFloat("meal_sugar"),
                r.getFloat("meal_sodium"));
    }