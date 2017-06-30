package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.order.OrderDao;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.bdo.Order;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.*;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Order API", description = "Provides order functionality.")
public class OrderResource {

    private final ConnectionFactory connectionFactory;

    public OrderResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @GET
    @Path("/all")
    @ApiOperation(value = "Get all orders")
    public List<Order> getAllOrders(@Auth User user) {
        return null;
    }

    @GET
    @Path("/open")
    @ApiOperation(value = "Get all open orders")
    public Order getOpenOrders (@Auth User user) {
        return null;
    }

    @GET
    @Path("/order/{orderId}")
    @ApiOperation(value = "Get information of a order")
    public Order getOrder(@PathParam("orderId") int orderId){
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            com.tum.fbl.core.persistence.order.Order order = orderDao.findOrderById(orderId);
            return null;
            /*
            return new Order(
                    order.getOrderId(),
                    order.getOrderUserId(),
                    order.getOrderMealId(),
                    order.getOrderPickupTime(),
                    order.getOrderStatus()

            )
            */
        }
    }

    @GET
    @Path("/restaurant/{restaurantId}")
    @ApiOperation(value = "Get open orders of a restaurants")
    public Order getOrdersForRestaurant (@PathParam("restaurantId") int restaurantId) {
        return null;
    }

    @PUT
    @ApiOperation(value = "Update an existing order")
    public void placeOrder (Order order) {

    }

    @POST
    @ApiOperation(value = "Add a new order to the store")
    public void addOrder(Order order) {
    }

    @DELETE
    @Path("/{orderId}")
    @ApiOperation(value = "Deletes a order")
    public void deleteOrder(@PathParam("orderId") int orderId) {

    }

}
