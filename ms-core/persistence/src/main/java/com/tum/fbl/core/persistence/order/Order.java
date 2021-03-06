package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.meal.Meal;
import com.tum.fbl.core.persistence.user.User;

import java.sql.Date;

public class Order {

    private int orderId;

    private int orderRestaurantId;

    private int orderUserId;

    private int orderMealId;

    private Date orderPickupTime;

    private int orderStatus;

    private int orderNumber;

    /**
     *
     * @param orderId the unique orderId
     * @param orderUserId the ordering user's ID
     * @param orderMealId the ordered meal's ID
     * @param orderPickupTime time when the meal is ready to be picked up
     * @param orderStatus current status of the order
     * @param orderNumber order's actual number at restaurant
     */
    public Order(int orderId, int orderUserId, int orderRestaurantId, int orderMealId, Date orderPickupTime, int orderStatus, int orderNumber) {
        this.orderId = orderId;
        this.orderUserId = orderUserId;
        this.orderRestaurantId = orderRestaurantId;
        this.orderMealId = orderMealId;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderRestaurantId() {
        return orderRestaurantId;
    }

    public void setOrderRestaurantId(int orderRestaurantId) {
        this.orderRestaurantId = orderRestaurantId;
    }
}