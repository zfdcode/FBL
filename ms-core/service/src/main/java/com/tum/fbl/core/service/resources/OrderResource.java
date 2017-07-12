package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.bdo.Restaurant;
import com.tum.fbl.core.bdo.User;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.meal.MealDao;
import com.tum.fbl.core.persistence.order.OrderDao;
import com.tum.fbl.core.persistence.user.UserDao;
import com.tum.fbl.core.bdo.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
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
        try (
                OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)
        ) {
            List<Order> orders = new ArrayList<>();
            for (com.tum.fbl.core.persistence.order.Order order : orderDao.getOrderList()) {
                User user = new User(userDao.findUserById(order.getOrderUserId()));
                Restaurant restaurant = new Restaurant(userDao.findUserById(order.getOrderRestaurantId()));
                Meal meal = new Meal(mealDao.findMealById(order.getOrderMealId()));
                orders.add(new Order(order,user,restaurant,meal));
            }
            return orders;
        }
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

        try (
                OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)
             ) {
            com.tum.fbl.core.persistence.order.Order order = orderDao.findOrderById(orderId);
            User user = new User(userDao.findUserById(order.getOrderUserId()));
            Restaurant restaurant = new Restaurant(userDao.findUserById(order.getOrderRestaurantId()));
            Meal meal = new Meal(mealDao.findMealById(order.getOrderMealId()));
            return new Order(
                    order,
                    user,
                    restaurant,
                    meal);
        }

    }

    /**
     * Gets orders for restaurant
     * @param restaurantId the restaurant id
     * @return Order
     */
    @GET
    @Path("/restaurant/{restaurantId}")
    @ApiOperation(value = "Get open orders of a restaurants")
    public List<Order> getOrdersForRestaurant(@PathParam("restaurantId") int restaurantId) {
        try (
                OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)
        ) {
            List<Order> orders = new ArrayList<>();
            for (com.tum.fbl.core.persistence.order.Order order : orderDao.findOrdersByRestaurant(restaurantId)) {
                User user = new User(userDao.findUserById(order.getOrderUserId()));
                Restaurant restaurant = new Restaurant(userDao.findUserById(order.getOrderRestaurantId()));
                Meal meal = new Meal(mealDao.findMealById(order.getOrderMealId()));
                orders.add(new Order(order,user,restaurant,meal));
            }
            return orders;
        }
    }

    /**
     * Updates order.
     * @param order the order
     */
    @PUT
    @ApiOperation(value = "Update an existing order")
    public void placeOrder(Order order) {
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            orderDao.setOrderStatus(order.getOrderStatus(), order.getOrderId());
        }
    }

    /**
     * Adds order.
     * @param order the order
     */
    @POST
    @ApiOperation(value = "Add a new order to the store")
    public int addOrder(Order order) {
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
        }*/
       try(OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)){
           return orderDao.newOrder(order.getOrderUser().getUserId(),
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
