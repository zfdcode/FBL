package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by zfngd on 2017/6/15.
 */

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "User API", description = "Provides the user information.")
public class UserResource {
    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic user information")
    public User getUser (@PathParam("userId") int userId) {
        return null;
    }

    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Deletes a user")
    public void deleteUser(@PathParam("userId") int userId) {

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Add a new user to the store")
    public void addUser(User user) {
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Update an existing user")
    public void updateUser(User user) {
    }

    @GET
    @Path("/{specialNeedId}")
    @ApiOperation(value = "Get users by special need")
    public List<User> getUsersBySpecialNeed(@PathParam("specialNeedId") int specialNeedId) {
        return null;
    }

    @GET
    @Path("/{ingredientId}")
    @ApiOperation(value = "Get users by selected ingredient")
    public List<User> getUsersByIngredient(@PathParam("ingredientId") int ingredientId) {
        return null;
    }

    @GET
    @Path("/{mealId}")
    @ApiOperation(value = "Get users by selected meal")
    public List<User> getUsersByMeal(@PathParam("mealId") int mealId) {
        return null;
    }
}
