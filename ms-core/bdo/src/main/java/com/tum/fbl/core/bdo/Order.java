package com.tum.fbl.core.bdo;

import java.util.Date;
import java.util.List;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Order {

    private int orderId;

    private User orderUser;

    private List<Meal> orderMeals;

    private Date orderPickupTime;

    private String orderStatus;

    public Order(int orderId, User orderUser, List<Meal> orderMeals, Date orderPickupTime, String orderStatus) {
        this.orderId = orderId;
        this.orderUser = orderUser;
        this.orderMeals = orderMeals;
        this.orderPickupTime = orderPickupTime;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public List<Meal> getOrderMeals() {
        return orderMeals;
    }

    public void setOrderMeals(List<Meal> orderMeals) {
        this.orderMeals = orderMeals;
    }

    public Date getOrderPickupTime() {
        return orderPickupTime;
    }

    public void setOrderPickupTime(Date orderPickupTime) {
        this.orderPickupTime = orderPickupTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

