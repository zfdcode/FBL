package com.tum.fbl.core.persistence.order;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.tum.fbl.core.persistence.order.Order;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;
/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(OrderMapper.class)
public interface OrderDao extends AutoCloseable{
    /**
     * selects an entry from the Order table in the database
     * @param orderId the unique ID of the entry to be selected
     * @return Order object
     */
    @SqlQuery("select * from order where orderId = :id")
    Order findOrderById(@Bind("id") int orderId);

    @SqlQuery("select * from order where restaurant = :restaurant")
    List<Order> findOrdersByRestaurant(@Bind("restaurant") int restaurant);
    /**
     * inserts a new entry into the Order table in the database
     * @param orderUserId the unique ID of the user who placed the order
     * @param orderMealId the unique ID of the ordered meal
     * @param orderPickupTime the time the order is ready to be picked up
     * @param orderStatus the order's current status
     */
    @SqlUpdate("insert into order ( restaurantId, userId, mealId, pickupTime, status, orderNumber)" +
            " values (:restaurantId, :userId, :mealId, :pickupTime, :status, :number)")
    @GetGeneratedKeys
    int newOrder(@Bind("restaurantId") int orderRestaurantId,
                 @Bind("userId") int orderUserId,
                  @Bind("mealId") int orderMealId,
                  @Bind("pickupTime") Date orderPickupTime,
                  @Bind("status") int orderStatus,
                 @Bind("number") int orderNumber);

    /**
     * deletes an entry with specified unique ID in the Order table
     * @param orderId the specified unique ID
     */
    @SqlUpdate("delete from order where orderId = :id")
    void deleteOrderById(@Bind("id") int orderId);

    //TODO: void update()

    /**
     * gets all open orders from the database
     * @return List of Order objects
     */
    @SqlQuery("select * from order where NOT(status = 'pickedUp' or status = 'canceled')")
    List<Order> getOrderList();

    /**
     * sets a new status for an order with a specified unique ID
     * @param orderStatus the new status
     * @param orderId the unique ID of the order
     */
    @SqlUpdate("update order set status= :status where orderId = :id")
    void setOrderStatus(@Bind("status") int orderStatus, @Bind("id") int orderId);

    void close();

}
