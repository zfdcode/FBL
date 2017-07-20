package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Ingredient;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.ingredient.IngredientDao;
import com.tum.fbl.core.persistence.tag.Tag;
import com.tum.fbl.core.persistence.tag.TagDao;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfngd on 2017/6/15.
 * Documented by jie on 03.07.2017.
 */
@Path("/ingredient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Ingredient API", description = "Provides ingredients.")
public class IngredientResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects to the factory for ingredient resource.
     *
     * @param connectionFactory the connection of factory
     */
    public IngredientResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all ingredients.
     *
     * @return list of ingredient
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered ingredients")
    public List<Ingredient> getAllIngredients() {

        try (
                IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
                TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)) {
            List<Ingredient> ingredients = new ArrayList<>();

            List<com.tum.fbl.core.persistence.ingredient.Ingredient> ingredientList = ingredientDao.getAllIngredients();

            if (ingredientList != null) {
                for (com.tum.fbl.core.persistence.ingredient.Ingredient ingredient : ingredientList) {
                    Ingredient ingredientBDO = updateIngredientBDO(ingredient, tagDao);
                    ingredients.add(ingredientBDO);
                }
            }
            return ingredients;
        }
    }

    /**
     * Gets ingredient.
     *
     * @param ingredientId the ingredient id
     * @return Ingredient
     */
    @GET
    @Path("/id/{ingredientId}")
    @ApiOperation(value = "Get information of a ingredient")
    public Ingredient getIngredient(@PathParam("ingredientId") int ingredientId) {
        try (IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)
        ) {
            com.tum.fbl.core.persistence.ingredient.Ingredient ingredient = ingredientDao.findIngredientById(ingredientId);

            if (ingredient != null) {
                return updateIngredientBDO(ingredient, tagDao);
            } else {
                return null;
            }
        }
    }

    /**
     * Gets ingredient by tags
     *
     * @param ingredientTagID the ingredient tag id
     * @return Ingredient
     */
    @GET
    @Path("/tag/{ingredientTagID}")
    @ApiOperation(value = "Get information of a ingredient by tag id")
    public Ingredient getIngredientByTagID(@PathParam("ingredientTagID") int ingredientTagID) {
        return null;
    }

    @GET
    @Path("/meal/{mealId}")
    public List<Ingredient> getIngredientsByMealId(@PathParam("mealId") int mealId) {
        try (
                IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
                TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)
        ) {
            List<Ingredient> ingredients = new ArrayList<>();

            List<com.tum.fbl.core.persistence.ingredient.Ingredient> ingredientList = ingredientDao.getIngredientsByMealID(mealId);

            if (ingredientList != null) {
                for (com.tum.fbl.core.persistence.ingredient.Ingredient ingredient : ingredientList) {
                    Ingredient ingredientBDO = updateIngredientBDO(ingredient, tagDao);
                    ingredients.add(ingredientBDO);
                }
            }
            return ingredients;
        }
    }

    /**
     * Deletes ingredient.
     *
     * @param ingredientId the ingredient id
     */
    @DELETE
    @Path("/{ingredientId}")
    @ApiOperation(value = "Deletes a ingredient")
    public void deleteIngredient(@PathParam("ingredientId") int ingredientId) {
        try (IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class)) {
            ingredientDao.deleteIngredientById(ingredientId);
            ingredientDao.deleteAllIngredientTag(ingredientId);
        }
    }

    /**
     * Adds ingredient.
     *
     * @param ingredient the ingredient
     */
    @POST
    @ApiOperation(value = "Add a new ingredient to the store")
    public int addIngredient(Ingredient ingredient) throws IllegalArgumentExpection {

        if (ingredient != null) {
            try (
                    IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
                    TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)
            ) {
                int ingredientId = ingredientDao.newIngredient(
                        ingredient.getIngredientName(),
                        ingredient.getDescription(),
                        ingredient.getIngredientImage(),
                        ingredient.getEnergy(),
                        ingredient.getTotalFat(),
                        ingredient.getProtein(),
                        ingredient.getTotalCarbohydrate(),
                        ingredient.isGarnish(),
                        ingredient.getSugar()
                );

                if (ingredient.getTag() != null) {
                    for (String tagName : ingredient.getTag()) {
                        Tag tag = tagDao.findTagByName(tagName);
                        if (tag != null) {
                            ingredientDao.newIngredientTag(ingredientId, tag.getTagId());
                        } else {
                            int tagId = tagDao.newTag(tagName);
                            ingredientDao.newIngredientTag(ingredientId, tagId);
                        }
                    }
                }
                return ingredientId;
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

    /**
     * Updates ingredient.
     *
     * @param ingredient the ingredient
     */
    @PUT
    @ApiOperation(value = "Update an existing ingredient (description only so far)")
    public void updateIngredient(Ingredient ingredient) throws IllegalArgumentExpection {

        if (ingredient != null) {
            try (
                    IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
                    TagDao tagDao = this.connectionFactory.getConnection().open(TagDao.class)
            ) {
                ingredientDao.updateIngredient(ingredient.getIngredientId(), ingredient.getDescription());
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

    private Ingredient updateIngredientBDO(com.tum.fbl.core.persistence.ingredient.Ingredient ingredient, TagDao tagDao) {
        Ingredient ingredientBDO = new Ingredient(ingredient);
        List<Tag> tags = tagDao.getTagsByIngredientId(ingredient.getIngredientId());

        if (tags != null) {
            List<String> tagNames = new ArrayList<>();
            for (Tag tag : tags) {
                tagNames.add(tag.getTagName());
            }
            ingredientBDO.setTag(tagNames.toArray(new String[tagNames.size()]));
        }
        return ingredientBDO;
    }


}
