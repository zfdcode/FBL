package com.tum.fbl.core.persistence.order;

import com.tum.fbl.core.persistence.meal.Meal;

public class Order {

    private String orderId;

    private User orderUser;

    private Meal orderMeal;

    private Date orderPickupTime;

    private int orderStatus;

    public Order(String orderId, User orderUser, Meal orderMeal, Date orderPickupTime, int orderStatus) {
        this.orderId = orderId;
        this.orderUser = orderUser;
        this.orderMeal = orderMeal;
        this.orderPickupTime = orderPickupTime;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Meal getOrderMeal() {
        return orderMeal;
    }

    public void setOrderMeal(Meal orderMeal) {
        this.orderMeal = orderMeal;
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