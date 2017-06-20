package com.tum.fbl.core.persistence.ingredient;

import com.tum.fbl.core.persistence.ingredient.Ingredient;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class IngredientMapper implements ResultSetMapper<Ingredient> {

    @Override
    public Ingredient map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Ingredient(
                r.getInt("ingredientId"),
                r.getString("ingredientName"),
                r.getString("description"),
                r.getBytes("ingredientImage"),
                r.getFloat("energy"),
                r.getFloat("totalFat"),
                r.getFloat("protein"),
                r.getFloat("totalCarbohydrate"));
    }

}