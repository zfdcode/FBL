package com.tum.fbl.core.persistence.ingredient;

import com.tum.fbl.core.persistence.ingredient.Ingredient;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class IngredientMapper implements ResultSetMapper<Ingredient> {

    /**
     * Maps ingredient data stored in db to Ingredient.
     * @param index
     * @param r
     * @param ctx
     * @return Ingredient
     * @throws SQLException
     */
    @Override
    public Ingredient map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Ingredient(
                r.getInt("ingredientId"),
                r.getString("ingredientName"),
                r.getString("description"),
                r.getString("ingredientImage"),
                r.getFloat("energy"),
                r.getFloat("totalFat"),
                r.getFloat("protein"),
                r.getFloat("totalCarbohydrate"),
                r.getBoolean("isGarnish"),
                r.getFloat("sugar")
                );
    }

}