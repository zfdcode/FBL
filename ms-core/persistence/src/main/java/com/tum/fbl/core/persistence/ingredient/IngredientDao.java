package com.tum.fbl.core.persistence.ingredient;

import com.google.common.primitives.Bytes;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(IngredientMapper.class)
public interface IngredientDao extends AutoCloseable {

    @SqlQuery("select * from ingredient where ingredientId = :id")
    Ingredient findIngredientById(@Bind("id") int ingredientId);

    @SqlQuery("select * from ingredient")
    List<Ingredient> getAllIngredients();

    @SqlUpdate("Insert into ingredient (ingredientName, description, ingredientImage, energy, totalFat, protein, totalCarbohydrate, isGarnish, sugar) " +
            "value (:ingredientName, :description, :ingredientImage, :energy, :totalFat, :protein, :totalCarbohydrate, :isGarnish, sugar); SELECT LAST_INSERT_ID() from ingredient")
    int newIngredient(@Bind("ingredientName") String ingredientName,
                       @Bind("description") String description,
                       @Bind("ingredientImage") String ingredientImage,
                       @Bind("energy") float energy,
                       @Bind("totalFat") float totalFat,
                       @Bind("protein") float protein,
                       @Bind("totalCarbohydrate") float totalCarbohydrate,
                       @Bind("isGarnish") boolean isGarnish,
                       @Bind("sugar") float sugar);

    @SqlUpdate("delete from ingredient where ingredientId = :id")
    void deleteIngredientById(@Bind("id") int ingredientId);

    @SqlUpdate("Insert into IngredientTag (ingredientId, tagId) value (:ingredientId, : tagId) ")
    void setIngredientTag(@Bind("ingredientId") int ingredientId, @Bind("tagId") int tagId);

    public void close();
}
