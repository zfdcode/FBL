package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Restaurant {

    private int restaurantId;

    private String restaurantPassword;

    private String restaurantName;

    private String restaurantEmail;

    private String restaurantDisplayName;

    private String restaurantAddress;

    private Date[] restaurantOpeningHourMonday;

    private Date[] restaurantOpeningHourTuesday;

    private Date[] restaurantOpeningHourWednesday;

    private Date[] restaurantOpeningHourThursday;

    private Date[] restaurantOpeningHourFriday;

    private Date[] restaurantOpeningHourSaturday;

    private Date[] restaurantOpeningHourSunday;

    public Restaurant(int restaurantId, String restaurantPassword, String restaurantName, String restaurantEmail, String restaurantDisplayName, String restaurantAddress, Date[] restaurantOpeningHourMonday, Date[] restaurantOpeningHourTuesday, Date[] restaurantOpeningHourWednesday, Date[] restaurantOpeningHourThursday, Date[] restaurantOpeningHourFriday, Date[] restaurantOpeningHourSaturday, Date[] restaurantOpeningHourSunday) {
        this.restaurantId = restaurantId;
        this.restaurantPassword = restaurantPassword;
        this.restaurantName = restaurantName;
        this.restaurantEmail = restaurantEmail;
        this.restaurantDisplayName = restaurantDisplayName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantOpeningHourMonday = restaurantOpeningHourMonday;
        this.restaurantOpeningHourTuesday = restaurantOpeningHourTuesday;
        this.restaurantOpeningHourWednesday = restaurantOpeningHourWednesday;
        this.restaurantOpeningHourThursday = restaurantOpeningHourThursday;
        this.restaurantOpeningHourFriday = restaurantOpeningHourFriday;
        this.restaurantOpeningHourSaturday = restaurantOpeningHourSaturday;
        this.restaurantOpeningHourSunday = restaurantOpeningHourSunday;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    public String getRestaurantDisplayName() {
        return restaurantDisplayName;
    }

    public void setRestaurantDisplayName(String restaurantDisplayName) {
        this.restaurantDisplayName = restaurantDisplayName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Date[] getRestaurantOpeningHourMonday() {
        return restaurantOpeningHourMonday;
    }

    public void setRestaurantOpeningHourMonday(Date[] restaurantOpeningHourMonday) {
        this.restaurantOpeningHourMonday = restaurantOpeningHourMonday;
    }

    public Date[] getRestaurantOpeningHourTuesday() {
        return restaurantOpeningHourTuesday;
    }

    public void setRestaurantOpeningHourTuesday(Date[] restaurantOpeningHourTuesday) {
        this.restaurantOpeningHourTuesday = restaurantOpeningHourTuesday;
    }

    public Date[] getRestaurantOpeningHourWednesday() {
        return restaurantOpeningHourWednesday;
    }

    public void setRestaurantOpeningHourWednesday(Date[] restaurantOpeningHourWednesday) {
        this.restaurantOpeningHourWednesday = restaurantOpeningHourWednesday;
    }

    public Date[] getRestaurantOpeningHourThursday() {
        return restaurantOpeningHourThursday;
    }

    public void setRestaurantOpeningHourThursday(Date[] restaurantOpeningHourThursday) {
        this.restaurantOpeningHourThursday = restaurantOpeningHourThursday;
    }

    public Date[] getRestaurantOpeningHourFriday() {
        return restaurantOpeningHourFriday;
    }

    public void setRestaurantOpeningHourFriday(Date[] restaurantOpeningHourFriday) {
        this.restaurantOpeningHourFriday = restaurantOpeningHourFriday;
    }

    public Date[] getRestaurantOpeningHourSaturday() {
        return restaurantOpeningHourSaturday;
    }

    public void setRestaurantOpeningHourSaturday(Date[] restaurantOpeningHourSaturday) {
        this.restaurantOpeningHourSaturday = restaurantOpeningHourSaturday;
    }

    public Date[] getRestaurantOpeningHourSunday() {
        return restaurantOpeningHourSunday;
    }

    public void setRestaurantOpeningHourSunday(Date[] restaurantOpeningHourSunday) {
        this.restaurantOpeningHourSunday = restaurantOpeningHourSunday;
    }
}
