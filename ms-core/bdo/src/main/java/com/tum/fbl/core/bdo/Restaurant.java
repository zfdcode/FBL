package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Restaurant {

    private int restaurant_id;

    private String restaurant_password;

    private String restaurant_name;

    private String restaurant_email;

    private String restaurant_display_name;

    private String restaurant_address;

    private Date[] restaurant_opening_hour_monday;

    private Date[] restaurant_opening_hour_tuesday;

    private Date[] restaurant_opening_hour_wednesday;

    private Date[] restaurant_opening_hour_thursday;

    private Date[] restaurant_opening_hour_friday;

    private Date[] restaurant_opening_hour_saturday;

    private Date[] restaurant_opening_hour_sunday;

    public Restaurant(int restaurant_id, String restaurant_password, String restaurant_name, String restaurant_email, String restaurant_display_name, String restaurant_address, Date[] restaurant_opening_hour_monday, Date[] restaurant_opening_hour_tuesday, Date[] restaurant_opening_hour_wednesday, Date[] restaurant_opening_hour_thursday, Date[] restaurant_opening_hour_friday, Date[] restaurant_opening_hour_saturday, Date[] restaurant_opening_hour_sunday) {
        this.restaurant_id = restaurant_id;
        this.restaurant_password = restaurant_password;
        this.restaurant_name = restaurant_name;
        this.restaurant_email = restaurant_email;
        this.restaurant_display_name = restaurant_display_name;
        this.restaurant_address = restaurant_address;
        this.restaurant_opening_hour_monday = restaurant_opening_hour_monday;
        this.restaurant_opening_hour_tuesday = restaurant_opening_hour_tuesday;
        this.restaurant_opening_hour_wednesday = restaurant_opening_hour_wednesday;
        this.restaurant_opening_hour_thursday = restaurant_opening_hour_thursday;
        this.restaurant_opening_hour_friday = restaurant_opening_hour_friday;
        this.restaurant_opening_hour_saturday = restaurant_opening_hour_saturday;
        this.restaurant_opening_hour_sunday = restaurant_opening_hour_sunday;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_password() {
        return restaurant_password;
    }

    public void setRestaurant_password(String restaurant_password) {
        this.restaurant_password = restaurant_password;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_email() {
        return restaurant_email;
    }

    public void setRestaurant_email(String restaurant_email) {
        this.restaurant_email = restaurant_email;
    }

    public String getRestaurant_display_name() {
        return restaurant_display_name;
    }

    public void setRestaurant_display_name(String restaurant_display_name) {
        this.restaurant_display_name = restaurant_display_name;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public Date[] getRestaurant_opening_hour_monday() {
        return restaurant_opening_hour_monday;
    }

    public void setRestaurant_opening_hour_monday(Date[] restaurant_opening_hour_monday) {
        this.restaurant_opening_hour_monday = restaurant_opening_hour_monday;
    }

    public Date[] getRestaurant_opening_hour_tuesday() {
        return restaurant_opening_hour_tuesday;
    }

    public void setRestaurant_opening_hour_tuesday(Date[] restaurant_opening_hour_tuesday) {
        this.restaurant_opening_hour_tuesday = restaurant_opening_hour_tuesday;
    }

    public Date[] getRestaurant_opening_hour_wednesday() {
        return restaurant_opening_hour_wednesday;
    }

    public void setRestaurant_opening_hour_wednesday(Date[] restaurant_opening_hour_wednesday) {
        this.restaurant_opening_hour_wednesday = restaurant_opening_hour_wednesday;
    }

    public Date[] getRestaurant_opening_hour_thursday() {
        return restaurant_opening_hour_thursday;
    }

    public void setRestaurant_opening_hour_thursday(Date[] restaurant_opening_hour_thursday) {
        this.restaurant_opening_hour_thursday = restaurant_opening_hour_thursday;
    }

    public Date[] getRestaurant_opening_hour_friday() {
        return restaurant_opening_hour_friday;
    }

    public void setRestaurant_opening_hour_friday(Date[] restaurant_opening_hour_friday) {
        this.restaurant_opening_hour_friday = restaurant_opening_hour_friday;
    }

    public Date[] getRestaurant_opening_hour_saturday() {
        return restaurant_opening_hour_saturday;
    }

    public void setRestaurant_opening_hour_saturday(Date[] restaurant_opening_hour_saturday) {
        this.restaurant_opening_hour_saturday = restaurant_opening_hour_saturday;
    }

    public Date[] getRestaurant_opening_hour_sunday() {
        return restaurant_opening_hour_sunday;
    }

    public void setRestaurant_opening_hour_sunday(Date[] restaurant_opening_hour_sunday) {
        this.restaurant_opening_hour_sunday = restaurant_opening_hour_sunday;
    }
}
