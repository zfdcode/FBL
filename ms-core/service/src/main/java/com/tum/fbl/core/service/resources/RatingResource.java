package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Rating;
import com.tum.fbl.core.persistence.ConnectionFactory;
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
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Rating API", description = "Provides ratings.")
public class RatingResource {

    private final ConnectionFactory connectionFactory;

    public RatingResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByUserId (@PathParam("userId") int userId) {
        return null;
    }

    @GET
    @Path("/meal/{mealId}")
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
    @ApiOperation(value = "Add a new rating to the store")
    public void addRating(Rating rating) {
    }

    @PUT
    @ApiOperation(value = "Update an existing rating")
    public void updateRating(Rating rating) {
    }
}
