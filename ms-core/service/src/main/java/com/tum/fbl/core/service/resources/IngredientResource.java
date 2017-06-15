package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Ingredient;
import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
/**
 * Created by zfngd on 2017/6/15.
 */
@Path("/ingredient")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Ingredient API", description = "Provides ingredients.")
public class IngredientResource {
    @Path("/all")
    @ApiOperation(value = "Get all offered ingredients")
    public List<Ingredient> getAllIngredients(@Auth User user) {
        return null;
    }

    @GET
    @Path("/{ingredientId}")
    @ApiOperation(value = "Get information of a ingredient")
    public Ingredient getIngredient(@PathParam("ingredientId") int ingredientId){
        return null;
    }

    @GET
    @Path("/{ingredientTags}")
    @ApiOperation(value = "Get information of a ingredient")
    public Ingredient getIngredientByTags(@PathParam("ingredientTags") String ingredientTags){
        return null;
    }

    @DELETE
    @Path("/{ingredientId}")
    @ApiOperation(value = "Deletes a ingredient")
    public void deleteIngredient(@PathParam("ingredientId") int ingredientId) {

    }

    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Add a new ingredient to the store")
    public void addIngredient(Ingredient ingredient) {
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Update an existing ingredient")
    public void updateIngredient(Ingredient ingredient) {
    }


}
