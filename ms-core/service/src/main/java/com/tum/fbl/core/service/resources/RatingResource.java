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
 * Documented by jie on 03.07.2017.
 */
@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Rating API", description = "Provides ratings.")
public class RatingResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects the factory for rating resource.
     * @param connectionFactory the connection factory
     */
    public RatingResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets rating by userID.
     * @param userId the user id
     * @return list of rating
     */
    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByUserId (@PathParam("userId") int userId) {
        return null;
    }

    /**
     * Gets ratings by mealID
     * @param mealId the meal id
     * @return
     */
    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByMealId (@PathParam("mealId") int mealId) {
        return null;
    }

    /**
     * Gets rating.
     * @param userId the user id
     * @param mealId the meal id
     * @return rating
     */
    @DELETE
    @Path("/{userId}/{mealId}")
    @ApiOperation(value = "Deletes a rating by user ID")
    public Rating getRating(@PathParam("userId") int userId, @PathParam("mealId") int mealId) {
        return null;
    }

    /**
     * Deletes rating.
     * @param ratingId the rating id
     */
    @DELETE
    @Path("/{ratingId}")
    @ApiOperation(value = "Deletes a rating")
    public void deleteRating(@PathParam("ratingId") int ratingId) {

    }

    /**
     * Adds rating.
     * @param rating the rating
     */
    @POST
    @ApiOperation(value = "Add a new rating to the store")
    public void addRating(Rating rating) {
    }

    /**
     * Updates rating.
     * @param rating rating
     */
    @PUT
    @ApiOperation(value = "Update an existing rating")
    public void updateRating(Rating rating) {
    }
}
