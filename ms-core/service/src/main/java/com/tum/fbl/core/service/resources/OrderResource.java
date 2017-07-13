package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.bdo.Restaurant;
import com.tum.fbl.core.bdo.User;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.meal.MealDao;
import com.tum.fbl.core.persistence.order.OrderDao;
import com.tum.fbl.core.persistence.user.UserDao;
import com.tum.fbl.core.bdo.Order;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
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
            List<com.tum.fbl.core.persistence.order.Order> orderList = orderDao.getOrderList();
            if (orderList != null) {
                for (com.tum.fbl.core.persistence.order.Order order : orderList) {

                    com.tum.fbl.core.persistence.user.User userDb = userDao.findUserById(order.getOrderUserId());
                    User user;
                    if (userDb != null) {
                        user = new User(userDb);
                    } else {
                        user = new User();
                    }

                    com.tum.fbl.core.persistence.user.User restaurantDb = userDao.findUserById(order.getOrderRestaurantId());
                    Restaurant restaurant;
                    if (restaurantDb != null) {
                        restaurant = new Restaurant(restaurantDb);
                    } else {
                        restaurant = new Restaurant();
                    }

                    Meal meal;
                    com.tum.fbl.core.persistence.meal.Meal mealDb = mealDao.findMealById(order.getOrderMealId());
                    if (mealDb != null) {
                        meal = new Meal(mealDb);
                    } else {
                        meal = new Meal();
                    }
                    orders.add(new Order(order, user, restaurant, meal));
                }
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

            if (order != null) {

                com.tum.fbl.core.persistence.user.User userDb = userDao.findUserById(order.getOrderUserId());
                User user;
                if (userDb != null) {
                    user = new User(userDb);
                } else {
                    user = new User();
                }

                com.tum.fbl.core.persistence.user.User restaurantDb = userDao.findUserById(order.getOrderRestaurantId());
                Restaurant restaurant;
                if (restaurantDb != null) {
                    restaurant = new Restaurant(restaurantDb);
                } else {
                    restaurant = new Restaurant();
                }

                com.tum.fbl.core.persistence.meal.Meal mealDb = mealDao.findMealById(order.getOrderMealId());
                Meal meal;
                if (mealDb != null) {
                    meal = new Meal(mealDb);
                } else {
                    meal = new Meal();
                }
                return new Order(
                        order,
                        user,
                        restaurant,
                        meal);

            } else {
                return null;
            }
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

            List<com.tum.fbl.core.persistence.order.Order> orderList = orderDao.findOrdersByRestaurant(restaurantId);
            if (orderList != null) {
                for (com.tum.fbl.core.persistence.order.Order order : orderList) {

                    com.tum.fbl.core.persistence.user.User userDb = userDao.findUserById(order.getOrderUserId());
                    User user;
                    if (userDb != null) {
                        user = new User(userDb);
                    } else {
                        user = new User();
                    }


                    com.tum.fbl.core.persistence.user.User restaurantDb = userDao.findUserById(order.getOrderRestaurantId());
                    Restaurant restaurant;
                    if (restaurantDb != null) {
                        restaurant = new Restaurant(restaurantDb);
                    } else {
                        restaurant = new Restaurant();
                    }

                    com.tum.fbl.core.persistence.meal.Meal mealDb = mealDao.findMealById(order.getOrderMealId());
                    Meal meal;
                    if (mealDb != null) {
                        meal = new Meal(mealDb);
                    } else {
                        meal = new Meal();
                    }

                    orders.add(new Order(order, user, restaurant, meal));
                }
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
    public int addOrder(Order order) throws IllegalArgumentExpection {
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

        if (order != null) {
            try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
                return orderDao.newOrder(order.getOrderRestaurant().getRestaurantId(),
                        order.getOrderUser().getUserId(),
                        order.getOrderMeal().getMealId(),
                        order.getOrderPickupTime(),
                        order.getOrderStatus(),
                        order.getOrderNumber());
            }
        } else {
            throw new IllegalArgumentExpection();
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
