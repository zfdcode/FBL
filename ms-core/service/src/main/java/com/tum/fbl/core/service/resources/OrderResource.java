package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "com.tum.fbl.core.persistence.order.Order API", description = "Provides order functionality.")
public class OrderResource {

    @GET
    @Path("/open")
    @ApiOperation(value = "Get all open orders")
    public String getOpenOrders (@Auth User user) {
        return "running";
    }

    @GET
    @Path("/restaurant")
    @ApiOperation(value = "Get open oders of a restaurants")
    public String getOrdersForRestaurant (@Auth User user) {
        return "running";
    }

    @PUT
    @ApiOperation(value = "Place new order")
    public String placeOrder (@Auth User user) {
        return "running";
    }


}
