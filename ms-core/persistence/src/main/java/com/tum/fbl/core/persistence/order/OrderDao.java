package com.tum.fbl.core.persistence.order;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(OrderMapper.class)
public interface OrderDao extends AutoCloseable{

    @SqlQuery("select * from order where orderId = :id")
    Category findOrderById(@Bind("id") int orderId);

    @SqlUpdate("Insert into ingredient (orderUserId, orderMealId, orderPickupTime, orderStatus) value (:orderUserId, :orderMealId, :orderPickupTime, :orderStatus)")
    void newOrder(@Bind("orderUserId") int orderUserId,
                  @Bind("orderMealId") int orderMealId,
                  @Bind("orderPickupTime") Date orderPickupTime,
                  @Bind("orderStatus") int orderStatus);

    @SqlUpdate("delete from order where orderId = :id")
    void findOrderById(@Bind("id") int orderId);

    @SqlQuery("select * from order where NOT(status = 'pickedUp' or status = 'canceled')")
    Order getOrderList();

    @SqlUpdate("update order set status= :newStatus where orderId = :id”)
    void setOrderStatus@Bind("orderStatus") int orderStatus, @Bind("id") int orderId);
}
