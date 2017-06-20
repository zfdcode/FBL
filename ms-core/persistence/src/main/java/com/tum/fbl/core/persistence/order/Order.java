package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.meal.Meal;
import com.tum.fbl.core.persistence.user.User;

import java.util.Date;

public class Order {

    private int orderId;

    private int orderUserId;

    private int orderMealId;

    private Date orderPickupTime;

    private int orderStatus;

    public Order(int orderId, int orderUserId, int orderMealId, Date orderPickupTime, int orderStatus) {
        this.orderId = orderId;
        this.orderUserId = orderUserId;
        this.orderMealId = orderMealId;
        this.orderPickupTime = orderPickupTime;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(int orderUserId) {
        this.orderUserId = orderUserId;
    }

    public int getOrderMealId() {
        return orderMealId;
    }

    public void setOrderMealId(int orderMealId) {
        this.orderMealId = orderMealId;
    }

    public Date getOrderPickupTime() {
        return orderPickupTime;
    }

    public void setOrderPickupTime(Date orderPickupTime) {
        this.orderPickupTime = orderPickupTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}