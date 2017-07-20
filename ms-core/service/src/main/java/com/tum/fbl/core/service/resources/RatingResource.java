package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.bdo.Rating;
import com.tum.fbl.core.bdo.User;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.meal.MealDao;
import com.tum.fbl.core.persistence.rating.RatingDao;
import com.tum.fbl.core.persistence.user.UserDao;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.sql.Date;
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
     * Connects to the factory for rating resource.
     *
     * @param connectionFactory the connection of factory
     */
    public RatingResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets ratings by user id.
     *
     * @param userId the user id
     * @return List<Rating> the list of ratings
     */
    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByUserId(@PathParam("userId") int userId) {
        try (
                RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)
        ) {
            List<Rating> ratings = new ArrayList<>();
            for (com.tum.fbl.core.persistence.rating.Rating rating : ratingDao.findRatingsByUserId(userId)) {

                User user = new User(userDao.findUserById(rating.getUserId()));
                Meal meal = new Meal(mealDao.findMealById(rating.getMealId()));
                ratings.add(new Rating(rating.getRatingId(), user, meal, rating.isRating()));
            }
            return ratings;
        }
    }

    /**
     * Gets raitings by meal id
     *
     * @param mealId the meal id
     * @return List<Rating> the list of ratings
     */
    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get ratings by user id")
    public List<Rating> getRatingsByMealId(@PathParam("mealId") int mealId) {
        try (
                RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)
        ) {
            List<Rating> ratings = new ArrayList<>();
            for (com.tum.fbl.core.persistence.rating.Rating rating : ratingDao.findRatingsByMealId(1)) {

                User user = new User(userDao.findUserById(rating.getUserId()));
                Meal meal = new Meal(mealDao.findMealById(rating.getMealId()));
                ratings.add(new Rating(rating.getRatingId(), user, meal, rating.isRating()));
            }
            return ratings;
        }
    }

    /**
     * Gets rating.
     *
     * @param ratingId the id
     * @return Rating
     */
    @GET
    @Path("/{ratingId}")
    @ApiOperation(value = "Get a rating by id")
    public Rating getRating(@PathParam("ratingId") int ratingId) {
        try (
                RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)
        ) {
            com.tum.fbl.core.persistence.rating.Rating rating = ratingDao.findRatingById(ratingId);
            if (rating != null) {

                com.tum.fbl.core.persistence.user.User userDb = userDao.findUserById(rating.getUserId());
                User user;
                if (userDb != null) {
                     user = new User(userDb);
                } else {
                    user = new User();
                }

                com.tum.fbl.core.persistence.meal.Meal mealDb = mealDao.findMealById(rating.getMealId());
                Meal meal;
                if (mealDb != null) {
                    meal = new Meal(mealDb);
                } else {
                    meal = new Meal();
                }

                return new Rating(rating.getRatingId(), user, meal, rating.isRating());
            } else {
                return null;
            }
        }
    }

    /**
     * Deletes rating.
     *
     * @param ratingId the rating id
     */
    @DELETE
    @Path("/{ratingId}")
    @ApiOperation(value = "Deletes a rating")
    public void deleteRating(@PathParam("ratingId") int ratingId) {
        try (RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class)) {
            ratingDao.deleteRatingById(ratingId);
        }
    }

    /**
     * Adds rating.
     *
     * @param rating the rating
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Add a new rating to the store")
    public int addRating(@QueryParam("userId") int userId, @QueryParam("mealId") int mealId, @QueryParam("rating") boolean rating) {
        try (RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class)) {
            return ratingDao.newRating(userId, mealId, new Date(0), rating);
        }
    }

    /**
     * Updates rating.
     *
     * @param rating the rating
     */
    @PUT
    @ApiOperation(value = "Update an existing rating")
    public void updateRating(Rating rating) {
        if (rating != null) {
            try (
                    RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class)
            ) {
                ratingDao.updateRating(rating.getRatingId(), rating.getRate(), rating.getRatingTimestamp());
                //update meal rating
                //TODO:
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }
}
