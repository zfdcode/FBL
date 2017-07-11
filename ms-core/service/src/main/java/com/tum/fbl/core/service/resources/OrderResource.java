package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.meal.MealDao;
import com.tum.fbl.core.persistence.order.OrderDao;
import com.tum.fbl.core.persistence.user.UserDao;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.bdo.Order;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.core.MediaType;
import java.util.Date;
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
     * Connects to the factory for order resource.
     * @param connectionFactory the connection of factory
     */
    public OrderResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all order.
     * @return List<Order> the list of orders
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all orders")
    public List<Order> getAllOrders() {
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
    public Order getOrder(@PathParam("orderId") int orderId) {
        return null;
    /*    try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            com.tum.fbl.core.persistence.order.Order order = orderDao.findOrderById(orderId);

            try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
                com.tum.fbl.core.persistence.user.User user = userDao.findUserById(order.getOrderUserId());

                com.tum.fbl.core.bdo.User userBdo = new com.tum.fbl.core.bdo.User(user);

                try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
                    com.tum.fbl.core.persistence.meal.Meal meal = mealDao.findMealById(order.getOrderMealId());

                    com.tum.fbl.core.bdo.Meal mealBdo = new com.tum.fbl.core.bdo.Meal(meal);

                    return new Order(orderId, userBdo, mealBdo, null, order.getOrderStatus(), order.getOrderNumber());
                }
            }

        }

*/
    }

    /**
     * Gets orders for restaurant
     * @param restaurantId the restaurant id
     * @return Order
     */
    @GET
    @Path("/restaurant/{restaurantId}")
    @ApiOperation(value = "Get open orders of a restaurants")
    public Order getOrdersForRestaurant(@PathParam("restaurantId") int restaurantId) {
        //TODO:
        return null;
    }

    /**
     * Updates order.
     * @param order the order
     */
    @PUT
    @ApiOperation(value = "Update an existing order")
    public void placeOrder(Order order) {
        /*
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {

            order Dao.setOrderStatus(Integer.parseInt(order.getOrderStatus()), order.getOrderId());
        }
        */
    }

    /**
     * Adds order.
     * @param order the order
     */
    @POST
    @ApiOperation(value = "Add a new order to the store")
    public void addOrder(Order order) {

       /*
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {

            List<Meal> ordermeals = order.getOrderMeals();
            int[] orderMealIds = new int[ordermeals.size()];
            for (int i = 0; i < ordermeals.size(); i++) {
                orderMealIds[i] = ordermeals.get(i).getMealId();
            }
            orderDao.newOrder(
                    order.getOrderUser().getUserId(),
                    orderMealIds,
                    order.getOrderPickupTime(),
                    Integer.parseInt(order.getOrderStatus())
            );
        }
        */

       try(OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)){
           orderDao.newOrder(order.getOrderUser().getUserId(),
                   order.getOrderMeal().getMealId(),
                   order.getOrderPickupTime(),
                   order.getOrderStatus());
       }

    }

    /**
     * Deletes order
     * @param orderId the order id
     */
    @DELETE
    @Path("/{orderId}")
    @ApiOperation(value = "Deletes a order")
    public void deleteOrder(@PathParam("orderId") int orderId) {
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            orderDao.deleteOrderById(orderId);
        }
    }

}
