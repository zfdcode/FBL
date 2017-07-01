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
import java.util.List;
import javax.ws.rs.*;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Order API", description = "Provides order functionality.")
public class OrderResource {

    private final ConnectionFactory connectionFactory;

    public OrderResource(ConnectionFactory connectionFactory) {
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
    public Order getOpenOrders(@Auth User user) {
        return null;
    }

    @GET
    @Path("/order/{orderId}")
    @ApiOperation(value = "Get information of a order")
    public Order getOrder(@PathParam("orderId") int orderId) {
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            com.tum.fbl.core.persistence.order.Order order = orderDao.findOrderById(orderId);
            int[] orderMealIds = order.getOrderMealIds();
            List<Meal> orderMeals = null;
            try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
                for (int orderMealId : orderMealIds) {
                    com.tum.fbl.core.persistence.meal.Meal meal = mealDao.findMealById(orderMealId);
                    Meal newOrderMeal = new Meal(
                            meal.getMealId(),
                            meal.getMealName(),
                            meal.getMealImage(),
                            meal.getMealRating(),
                            meal.getMealHelathValue(),
                            meal.getMealPreparationTime(),
                            meal.getOfferDate(),
                            meal.getMealEnergy(),
                            meal.getMealProtein(),
                            meal.getMealTotalFat(),
                            meal.getMealSaturated(),
                            meal.getMealTotalCarbohydrate(),
                            meal.getMealSugar(),
                            meal.getMealSodium(),
                            //TODO:
                            null,
                            null,
                            null
                    );
                    orderMeals.add(newOrderMeal);
                }
            }

            com.tum.fbl.core.bdo.User orderUser = null;
            try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
                com.tum.fbl.core.persistence.user.User user = userDao.findUserById(order.getOrderUserId());
                orderUser = new com.tum.fbl.core.bdo.User(
                        user.getUserId(),
                        user.getUserName(),
                        user.getUserPassword(),
                        user.getEmail(),
                        user.getBirthday(),
                        user.getHeight(),
                        user.getWeight()
                );
            }

            return new Order(
                    order.getOrderId(),
                    orderUser,
                    orderMeals,
                    order.getOrderPickupTime(),
                    Integer.toString(order.getOrderStatus())
            );
        }
    }

    @GET
    @Path("/restaurant/{restaurantId}")
    @ApiOperation(value = "Get open orders of a restaurants")
    public Order getOrdersForRestaurant(@PathParam("restaurantId") int restaurantId) {
        //TODO:
        return null;
    }

    @PUT
    @ApiOperation(value = "Update an existing order")
    public void placeOrder(Order order) {
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            orderDao.setOrderStatus(Integer.parseInt(order.getOrderStatus()), order.getOrderId());
        }
    }

    @POST
    @ApiOperation(value = "Add a new order to the store")
    public void addOrder(Order order) {
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
    }

    @DELETE
    @Path("/{orderId}")
    @ApiOperation(value = "Deletes a order")
    public void deleteOrder(@PathParam("orderId") int orderId) {
        try (OrderDao orderDao = this.connectionFactory.getConnection().open(OrderDao.class)) {
            orderDao.deleteOrderById(orderId);
        }
    }

}
