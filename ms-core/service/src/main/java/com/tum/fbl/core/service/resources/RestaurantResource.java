package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Restaurant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Restaurant API", description = "Provides the core data of all restaurants.")
public class RestaurantResource {

    @GET
    @Path("/all")
    @ApiOperation(value = "Get all Restaurants")
    public List<Restaurant> getAllRestaurants () {
        return null;
    }

    @GET
    @Path("/campus")
    @ApiOperation(value = "Get all restaurants at a campus")
    public List<Restaurant> getRestaurantsAtCampus () {
        return null;
    }

    @GET
    @Path("/{restaurantId}")
    @ApiOperation(value = "Get core information of a restaurant")
    public Restaurant getRestaurant (@PathParam("restaurantId") int restaurantId) {
        return null;
    }

    @DELETE
    @Path("/{restaurantId}")
    @ApiOperation(value = "Delete a restaurant")
    public void deleteRestaurant (@PathParam("restaurantId") int restaurantId) {

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Add a new restaurant to the store")
    public void addRestaurant(Restaurant restaurant) {

    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Update an existing restaurant")
    public void updatePet(Restaurant restaurant) {

    }

}
