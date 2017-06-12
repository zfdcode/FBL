package com.tum.fbl.core.service.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Restaurant API", description = "Provides the core data of all restaurants.")
public class RestaurantResource {

    @GET
    @Path("/all")
    @ApiOperation(value = "Get all Restaurants")
    public String getAllRestaurants () {
        return "running";
    }

    @GET
    @Path("/campus")
    @ApiOperation(value = "Get all restaurants at a campus")
    public String getRestaurantsAtCampus () {
        return "running";
    }

    @GET
    @ApiOperation(value = "Get core information of a restaurant")
    public String getRestaurant () {
        return "running";
    }

}
