package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.category.Category;
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
    Category findOrderById(@Bind("id") int orderId);

    @SqlUpdate("Insert into ingredient (orderUserId, orderMealId, orderPickupTime, orderStatus) value (:orderUserId, :orderMealId, :orderPickupTime, :orderStatus)")
    void newOrder(@Bind("orderUserId") int orderUserId,
                  @Bind("orderMealId") int orderMealId,
                  @Bind("orderPickupTime") Date orderPickupTime,
                  @Bind("orderStatus") int orderStatus);

    @SqlUpdate("delete from order where orderId = :id")
    void deleteOrderById(@Bind("id") int orderId);
}
