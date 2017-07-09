package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.order.Order;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(OrderMapper.class)
public interface OrderDao extends AutoCloseable{

    @SqlQuery("select * from order where orderId = :id")
    Order findOrderById(@Bind("id") int orderId);

    @SqlUpdate("Insert into ingredient (orderUserId, orderPickupTime, orderStatus, orderNumber) value (:orderUserId, :orderPickupTime, :orderStatus, :orderNumber)")
    void newOrder(@Bind("orderUserId") int orderUserId,
                  @Bind("orderPickupTime") Date orderPickupTime,
                  @Bind("orderStatus") int orderStatus,
                  @Bind("orderNumber") int orderNumber);

    @SqlUpdate("delete from order where orderId = :id")
    void deleteOrderById(@Bind("id") int orderId);

    //TODO: void update()

    public void close();

    @SqlQuery("select * from order where NOT(status = 'pickedUp' or status = 'canceled')")
    Order getOrderList();

    @SqlUpdate("update order set status= :newStatus where orderId = :id")
    void setOrderStatus(@Bind("orderStatus") int orderStatus, @Bind("id") int orderId);

}
