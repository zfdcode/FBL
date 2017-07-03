package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Ingredient;
import com.tum.fbl.core.persistence.ConnectionFactory;
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
     * Connects the factory for ingredient resource.
     * @param connectionFactory the connection factory
     */
    public IngredientResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all ingredients.
     * @param user the user
     * @return list of ingredient
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered ingredients")
    public List<Ingredient> getAllIngredients(@Auth User user) {
        return null;
    }

    /**
     * Gets ingredient.
     * @param ingredientId the ingredient id
     * @return ingredient
     */
    @GET
    @Path("/id/{ingredientId}")
    @ApiOperation(value = "Get information of a ingredient")
    public Ingredient getIngredient(@PathParam("ingredientId") int ingredientId){
        return null;
    }

    /**
     * Gets ingredient by tags.
     * @param ingredientTags the ingredient tags
     * @return ingredient
     */
    @GET
    @Path("/tag/{ingredientTags}")
    @ApiOperation(value = "Get information of a ingredient")
    public Ingredient getIngredientByTags(@PathParam("ingredientTags") String ingredientTags){
        return null;
    }

    /**
     * Deletes ingredient.
     * @param ingredientId the ingredient id
     */
    @DELETE
    @Path("/{ingredientId}")
    @ApiOperation(value = "Deletes a ingredient")
    public void deleteIngredient(@PathParam("ingredientId") int ingredientId) {

    }

    /**
     * Adds ingredient.
     * @param ingredient the ingredient
     */
    @POST
    @ApiOperation(value = "Add a new ingredient to the store")
    public void addIngredient(Ingredient ingredient) {
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
