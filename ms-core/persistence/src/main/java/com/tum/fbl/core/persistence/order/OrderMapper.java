package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.order.Order;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class OrderMapper implements ResultSetMapper<Order> {

    /**
     * Maps order data stored in db to Order.
     * @param index
     * @param r
     * @param ctx
     * @return Order
     * @throws SQLException
     */
    @Override
    public Order map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Order(
                r.getInt("orderId"),
                r.getInt("orderUserId"),
                r.getInt("orderMealId"),
                r.getDate("orderPickupTime"),
                r.getInt("orderStatus"));
    }

}