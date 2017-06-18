package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Order {

    private int order_id;

    private User order_user;

    private Meal order_meal;

    private Date order_pickup_time;

    private int order_status;

    public Order(int order_id, User order_user, Meal order_meal, Date order_pickup_time, int order_status) {
        this.order_id = order_id;
        this.order_user = order_user;
        this.order_meal = order_meal;
        this.order_pickup_time = order_pickup_time;
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public User getOrder_user() {
        return order_user;
    }

    public void setOrder_user(User order_user) {
        this.order_user = order_user;
    }

    public Meal getOrder_meal() {
        return order_meal;
    }

    public void setOrder_meal(Meal order_meal) {
        this.order_meal = order_meal;
    }

    public Date getOrder_pickup_time() {
        return order_pickup_time;
    }

    public void setOrder_pickup_time(Date order_pickup_time) {
        this.order_pickup_time = order_pickup_time;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}
