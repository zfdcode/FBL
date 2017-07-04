package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.bdo.Order;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.*;

/**
 * Documented by jie on 03.07.2017.
 */

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Order API", description = "Provides order functionality.")
public class OrderResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects the factory for order resource.
     * @param connectionFactory the connection factory
     */
    public OrderResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all orders.
     * @return list of order
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all orders")
    public List<Order> getAllOrders() {
        return null;
    }

    /**
     * Gets open orders.
     * @return order
     */
    @GET
    @Path("/open")
    @ApiOperation(value = "Get all open orders")
    public Order getOpenOrders () {
        return null;
    }

    /**
     * Gets order.
     * @param orderId the order id
     * @return order
     */
    @GET
    @Path("/order/{orderId}")
    @ApiOperation(value = "Get information of a order")
    public Order getOrder(@PathParam("orderId") int orderId){
        return null;
    }

    /**
     * Gets orders for restaurants.
     * @param restaurantId the restaurant id
     * @return order
     */
    @GET
    @Path("/restaurant/{restaurantId}")
    @ApiOperation(value = "Get open orders of a restaurants")
    public Order getOrdersForRestaurant (@PathParam("restaurantId") int restaurantId) {
        return null;
    }

    /**
     * Updates order.
     * @param order the order
     */
    @PUT
    @ApiOperation(value = "Update an existing order")
    public void placeOrder (Order order) {

    }

    /**
     * Adds order.
     * @param order the order
     */
    @POST
    @ApiOperation(value = "Add a new order to the store")
    public void addOrder(Order order) {
    }

    /**
     * Deletes order.
     * @param orderId the order id
     */
    @DELETE
    @Path("/{orderId}")
    @ApiOperation(value = "Deletes a order")
    public void deleteOrder(@PathParam("orderId") int orderId) {

    }

}
