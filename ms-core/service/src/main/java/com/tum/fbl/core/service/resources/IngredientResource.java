package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Ingredient;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.ingredient.IngredientDao;
import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
     * @param connectionFactory the connection of factory
     */
    public IngredientResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all ingredients.
     * @return list of ingredient
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered ingredients")
    public List<Ingredient> getAllIngredients() {
        /*
        try (IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class)) {
            List<com.tum.fbl.core.persistence.ingredient.Ingredient> ingredients = ingredientDao.findIngredients();
            //TODO: return List<Ingredient>
            return null;
        }

        */

        return null;
    }

    /**
     * Gets ingredient.
     * @param ingredientId the ingredient id
     * @return Ingredient
     */
    @GET
    @Path("/id/{ingredientId}")
    @ApiOperation(value = "Get information of a ingredient")
    public Ingredient getIngredient(@PathParam("ingredientId") int ingredientId) {
        /*
        try (IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class)) {
            com.tum.fbl.core.persistence.ingredient.Ingredient ingredient = ingredientDao.findIngredientById(ingredientId);
            return new Ingredient(
                    ingredient.getIngredientId(),
                    ingredient.getIngredientName(),
                    ingredient.getDescription(),
                    ingredient.getIngredientImage(),
                    ingredient.getEnergy(),
                    ingredient.getTotalFat(),
                    ingredient.getProtein(),
                    ingredient.getTotalCarbohydrate(),
                    ingredient.getTag()
            );
        }
        */
        return null;

    }

    /**
     * Gets ingredient by tags
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
    public Ingredient getIngredientByMealId(@PathParam("mealId") int mealId) {return null;}

    /**
     * Deletes ingredient.
     * @param ingredientId the ingredient id
     */
    @DELETE
    @Path("/{ingredientId}")
    @ApiOperation(value = "Deletes a ingredient")
    public void deleteIngredient(@PathParam("ingredientId") int ingredientId) {
        try (IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class)) {
            ingredientDao.deleteIngredientById(ingredientId);
        }
    }

    /**
     * Adds ingredient.
     * @param ingredient the ingredient
     */
    @POST
    @ApiOperation(value = "Add a new ingredient to the store")
    public int addIngredient(Ingredient ingredient) {
        return 0;
        /*
        try (IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class)) {
           return ingredientDao.newIngredient(
                    ingredient.getIngredientName(),
                    ingredient.getDescription(),
                    ingredient.getIngredientImage(),
                    ingredient.getEnergy(),
                    ingredient.getTotalFat(),
                    ingredient.getProtein(),
                    ingredient.getTotalCarbohydrate(),
                    ingredient.get
                    ingredient.getSugar()
            );
        } */
    }

    /**
     * Updates ingredient.
     * @param ingredient the ingredient
     */
    @PUT
    @ApiOperation(value = "Update an existing ingredient")
    public void updateIngredient(Ingredient ingredient) {
    }


}
