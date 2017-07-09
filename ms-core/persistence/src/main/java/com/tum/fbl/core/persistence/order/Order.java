package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.meal.Meal;
import com.tum.fbl.core.persistence.user.User;

import java.util.Date;

public class Order {

    private int orderId;

    private int orderUserId;

    private Date orderPickupTime;

    private int orderStatus;

    private int orderNumber;

    public Order(int orderId, int orderUserId, Date orderPickupTime, int orderStatus, int orderNumber) {
        this.orderId = orderId;
        this.orderUserId = orderUserId;
        this.orderPickupTime = orderPickupTime;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}