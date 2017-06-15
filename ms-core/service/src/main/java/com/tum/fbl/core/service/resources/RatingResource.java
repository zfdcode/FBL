package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Rating;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by zfngd on 2017/6/15.
 */
@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Rating API", description = "Provides ratings.")
public class RatingResource {

    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByUserId (@PathParam("userId") int userId) {
        return null;
    }

    @GET
    @Path("/{mealId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByMealId (@PathParam("mealId") int mealId) {
        return null;
    }

    @GET
    @Path("/{userId}/{mealId}")
    @ApiOperation(value = "Deletes a rating by user ID")
    public Rating getRating(@PathParam("userId") int userId, @PathParam("mealId") int mealId) {
        return null;
    }

    @DELETE
    @Path("/{ratingId}")
    @ApiOperation(value = "Deletes a rating")
    public void deleteRating(@PathParam("ratingId") int ratingId) {

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Add a new rating to the store")
    public void addRating(Rating rating) {
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Update an existing rating")
    public void updateRating(Rating rating) {
    }
}
