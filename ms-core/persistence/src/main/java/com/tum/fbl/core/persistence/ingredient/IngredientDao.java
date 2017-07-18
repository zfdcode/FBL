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
    /**
     * gets the information for a specified ingredientId from the Ingredient Table in the database
     * @param ingredientId the unique ID of the ingredient
     * @return Ingredient object
     */
    @SqlQuery("select * from Ingredient where ingredientId = :id")
    Ingredient findIngredientById(@Bind("id") int ingredientId);

    /**
     * gets all ingredients
     * @return List of Ingredient objects
     */
    @SqlQuery("select * from Ingredient")
    List<Ingredient> getAllIngredients();

    /**
     * inserts a new entry into the Ingredient table
     * @param ingredientName the ingredient's name
     * @param description the ingredient's description
     * @param ingredientImage the URL to an image of the ingredient
     * @param energy the energy the ingredient contains
     * @param totalFat the total amount of fat the ingredient contains
     * @param protein the total protein the ingredient contains
     * @param totalCarbohydrate the total amount of carbohydrates the ingredient contains
     * @param isGarnish true if the ingredient is a garnish, false otherwise
     * @param sugar the total amount of sugar the ingredient contains
     * @return the unique ID of the newly added ingredient
     */
    @SqlUpdate("Insert into Ingredient (ingredientName, description, image, energy, totalFat, protein, totalCarbohydrate, isGarnish, sugar) " +
            "values (:ingredientName, :description, :image, :energy, :totalFat, :protein, :totalCarbohydrate, :isGarnish, :sugar); SELECT LAST_INSERT_ID() from Ingredient")
    int newIngredient(@Bind("ingredientName") String ingredientName,
                       @Bind("description") String description,
                       @Bind("image") String ingredientImage,
                       @Bind("energy") float energy,
                       @Bind("totalFat") float totalFat,
                       @Bind("protein") float protein,
                       @Bind("totalCarbohydrate") float totalCarbohydrate,
                       @Bind("isGarnish") boolean isGarnish,
                       @Bind("sugar") float sugar);

    /**
     * deletes an entry with specified unique ID from the database
     * @param ingredientId the ID of the entry that will be deleted
     */
    @SqlUpdate("delete from Ingredient where ingredientId = :id")
    void deleteIngredientById(@Bind("id") int ingredientId);

    @SqlUpdate("update Ingredient set description= :description where ingredientId= : ingredientId")
    void updateIngredient(@Bind("ingredientId") int ingredientId, @Bind("description") String description);

    @SqlUpdate("Insert into IngredientTag (ingredientId, tagId) values (:ingredientId, :tagId); SELECT LAST_INSERT_ID() from ingredientTag")
    int newIngredientTag(@Bind("ingredientId") int ingredientID, @Bind("tagId") int tagId);

    @SqlUpdate("delete from IngredientTag where ingredientId= :ingredientId")
    void deleteAllIngredientTag(@Bind("ingredientId") int ingredientId);

    @SqlQuery("select i.* from Ingredient i, MealIngredient m where i.ingredientId=m.ingredientId AND m.mealId=:mealId")
    List<Ingredient> getIngrediensByMealID(@Bind("mealId") int mealId);

    void close();
}
