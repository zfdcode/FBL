package com.tum.fbl.core.bdo;

import java.sql.Date;
import java.util.List;

/**
 * Created by patrickmelchner on 30.05.17.
 * Documented by jie on 27.06.2017.
 */
public class Order {

    private int orderId;

    private User orderUser;

    private Restaurant orderRestaurant;

    private Meal orderMeal;

    private Date orderPickupTime;

    private int orderStatus;

    private int orderNumber;

    public Order(){}

    /**
     * Constructs Order that is made by users with meal choices, pickup time and order status.
     * @param orderId unique ID of the order
     * @param orderUser user who makes the order
     * @param orderMeal meal choices of the order
     * @param orderPickupTime pickup time of the order that are preferred by the user
     * @param orderStatus status of the order
     */
    public Order(int orderId, User orderUser, Restaurant orderRestaurant, Meal orderMeal, Date orderPickupTime, int orderStatus, int orderNumber) {
        this.orderId = orderId;
        this.orderUser = orderUser;
        this.orderRestaurant = orderRestaurant;
        this.orderMeal = orderMeal;
        this.orderPickupTime = orderPickupTime;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
    }

    public Order(com.tum.fbl.core.persistence.order.Order order, User user, Restaurant restaurant, Meal meal){
        this.orderId = order.getOrderId();
        this.orderUser = user;
        this.orderRestaurant = restaurant;
        this.orderMeal = meal;
        this.orderStatus = order.getOrderStatus();
        this.orderNumber = order.getOrderNumber();
    }

    /**
     * Gets OrderId.
     * @return orderId unique ID of the order
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets OrderId.
     * @param orderId unique ID of the order
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets OrderUser.
     * @return orderUser user who makes the order
     */
    public User getOrderUser() {
        return orderUser;
    }

    /**
     * Sets OrderUser.
     * @param orderUser user who makes the order
     */
    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Restaurant getOrderRestaurant() {
        return orderRestaurant;
    }

    public void setOrderRestaurant(Restaurant orderRestaurant) {
        this.orderRestaurant = orderRestaurant;
    }

    /**
     * Gets OrderMeal.
     * @return orderMeal meals choices of the order
     */
    public Meal getOrderMeal() {
        return orderMeal;
    }

    /**
     * Sets OrderMeal.
     * @param orderMeal meal choices of the order
     */
    public void setOrderMeal(Meal orderMeal) {
        this.orderMeal = orderMeal;
    }

    /**
     * Gets OrderPickupTime.
     * @return orderPickupTime pickup time of the order that are preferred by the user
     */
    public Date getOrderPickupTime() {
        return orderPickupTime;
    }

    /**
     * Sets OrderPickupTime.
     * @param orderPickupTime pickup time of the order that are preferred by the user
     */
    public void setOrderPickupTime(Date orderPickupTime) {
        this.orderPickupTime = orderPickupTime;
    }

    /**
     * Gets OrderStatus.
     * @return orderStatus status of the order
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets OrderStatus.
     * @param orderStatus status of the order
     */
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



