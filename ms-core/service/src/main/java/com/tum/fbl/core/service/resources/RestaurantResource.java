package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Restaurant;
import com.tum.fbl.core.bdo.User;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.user.UserDao;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Documented by jie on 03.07.2017.
 */

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Restaurant API", description = "Provides the core data of all restaurants.")
public class RestaurantResource {

    private final int role = 1;
    private final ConnectionFactory connectionFactory;

    /**
     * Connects to the factory for restaurant resource.
     * @param connectionFactory the connection of factory
     */
    public RestaurantResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all restaurants.
     * @return List<Restaurant> the list of restaurants
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all Restaurants")
    public List<Restaurant> getAllRestaurants () {
         try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)){
             List<Restaurant> restaurants = new ArrayList<>();

             List<com.tum.fbl.core.persistence.user.User> restaurantList = userDao.getAllUser(this.role);
             if (restaurantList != null) {
                 for (com.tum.fbl.core.persistence.user.User restaurant : restaurantList) {
                     restaurants.add(new Restaurant(restaurant));
                 }
             }

             return restaurants;
         }
    }

    /**
     * Gets restaurant.
     * @param restaurantId the restaurant id
     * @return Restaurant
     */
    @GET
    @Path("/{restaurantId}")
    @ApiOperation(value = "Get core information of a restaurant")
    public Restaurant getRestaurant (@PathParam("restaurantId") int restaurantId) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User restaurant = userDao.findUserById(restaurantId);
            if (restaurant != null) {
                return new Restaurant(restaurant);
            } else {
                return null;
            }
        }
    }

    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get information of a restaurant by offered meal")
    public Restaurant getRestaurantByMeal(@PathParam("mealId") int mealId){
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User restaurant = userDao.findUserByMealId(mealId);

            if (restaurant != null) {
                return new Restaurant(restaurant);
            } else {
                return null;
            }
        }
    }

    @GET
    @Path("/order/{orderId}")
    @ApiOperation(value = "Get information of a restaurant by order")
    public Restaurant getRestaurantByOrder(@PathParam("orderId") int orderId) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User restaurant = userDao.findUserByOrderId(orderId);

            if (restaurant != null) {
                return new Restaurant(restaurant);
            } else {
                return null;
            }
        }
    }

    /**
     * Deletes restaurant.
     * @param restaurantId the restaurant id
     */
    @DELETE
    @Path("/{restaurantId}")
    @ApiOperation(value = "Delete a restaurant")
    public void deleteRestaurant (@PathParam("restaurantId") int restaurantId) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)){
            userDao.deleteUser(restaurantId);
        }
    }

    /**
     * Adds restaurant.
     * @param restaurant the restaurant
     */
    @POST
    @ApiOperation(value = "Add a new restaurant to the store")
    public int addRestaurant(Restaurant restaurant) throws IllegalArgumentExpection {
        if (restaurant != null) {
            try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
                return userDao.newUser(
                        restaurant.getRestaurantName(),
                        restaurant.getRestaurantPassword(),
                        restaurant.getRestaurantEmail(),
                        //note: a restaurant has no such informations
                        null,
                        0,
                        0,
                        restaurant.getRestaurantDisplayName(),
                        restaurant.getRestaurantAddress(),
                        restaurant.getLongitude(),
                        restaurant.getLatitude(),
                        this.role
                );
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

    /**
     * Updates restaurant.
     * @param restaurant the restaurant
     */
    @PUT
    @ApiOperation(value = "Update an existing restaurant")
    public void updateRestaurant(Restaurant restaurant) throws IllegalArgumentExpection {

        if (restaurant != null) {
            try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
                userDao.updateUser(
                        restaurant.getRestaurantName(),
                        restaurant.getRestaurantPassword(),
                        restaurant.getRestaurantEmail(),
                        0,
                        restaurant.getRestaurantDisplayName()
                );
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

}
