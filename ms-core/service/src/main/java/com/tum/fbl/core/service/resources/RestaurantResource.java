package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Restaurant;
import com.tum.fbl.core.persistence.ConnectionFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Documented by jie on 03.07.2017.
 */

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Restaurant API", description = "Provides the core data of all restaurants.")
public class RestaurantResource {

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
        return null;
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
        return null;
    }

    @GET
    @Path("/meal/{mealId}")
    public Restaurant getRestaurantByMeal(){return null;}

    @GET
    @Path("/order/{orderId}")
    public Restaurant getRestaurantByOrder() {return null;}

    /**
     * Deletes restaurant.
     * @param restaurantId the restaurant id
     */
    @DELETE
    @Path("/{restaurantId}")
    @ApiOperation(value = "Delete a restaurant")
    public void deleteRestaurant (@PathParam("restaurantId") int restaurantId) {

    }

    /**
     * Adds restaurant.
     * @param restaurant the restaurant
     */
    @POST
    @ApiOperation(value = "Add a new restaurant to the store")
    public void addRestaurant(Restaurant restaurant) {

    }

    /**
     * Updates restaurant.
     * @param restaurant the restaurant
     */
    @PUT
    @ApiOperation(value = "Update an existing restaurant")
    public void updatePet(Restaurant restaurant) {

    }

}
