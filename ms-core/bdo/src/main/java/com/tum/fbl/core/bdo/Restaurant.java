package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 * Documented by jie on 27.06.2017.
 */
public class Restaurant {

    private int restaurantId;

    private String restaurantPassword;

    private String restaurantName;

    private String restaurantEmail;

    private String restaurantDisplayName;

    private String restaurantAddress;

    private float longitude;

    private float latitude;

    private Date[] restaurantOpeningHourMonday;

    private Date[] restaurantOpeningHourTuesday;

    private Date[] restaurantOpeningHourWednesday;

    private Date[] restaurantOpeningHourThursday;

    private Date[] restaurantOpeningHourFriday;

    private Date[] restaurantOpeningHourSaturday;

    private Date[] restaurantOpeningHourSunday;

    /**
     * Constructs Restaurant that is specified by ID, password, name, Email, display name, address and opening hours of each day.
     * @param restaurantId unique ID of the restaurant
     * @param restaurantPassword password of the restaurant that complies with the ID
     * @param restaurantName name of the restaurant
     * @param restaurantEmail Email address of the restaurant
     * @param restaurantDisplayName display name of the restaurant
     * @param restaurantAddress address of the restaurant
     * @param restaurantOpeningHourMonday opening hours of the restaurant on Monday
     * @param restaurantOpeningHourTuesday opening hours of the restaurant on Tuesday
     * @param restaurantOpeningHourWednesday opening hours of the restaurant on Wednesday
     * @param restaurantOpeningHourThursday opening hours of the restaurant on Thursday
     * @param restaurantOpeningHourFriday opening hours of the restaurant on Friday
     * @param restaurantOpeningHourSaturday opening hours of the restaurant on Saturday
     * @param restaurantOpeningHourSunday opening hours of the restaurant on Sunday
     */
    public Restaurant(int restaurantId, String restaurantPassword, String restaurantName, String restaurantEmail, String restaurantDisplayName, String restaurantAddress, float longitude, float latitude, Date[] restaurantOpeningHourMonday, Date[] restaurantOpeningHourTuesday, Date[] restaurantOpeningHourWednesday, Date[] restaurantOpeningHourThursday, Date[] restaurantOpeningHourFriday, Date[] restaurantOpeningHourSaturday, Date[] restaurantOpeningHourSunday) {
        this.restaurantId = restaurantId;
        this.restaurantPassword = restaurantPassword;
        this.restaurantName = restaurantName;
        this.restaurantEmail = restaurantEmail;
        this.restaurantDisplayName = restaurantDisplayName;
        this.restaurantAddress = restaurantAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.restaurantOpeningHourMonday = restaurantOpeningHourMonday;
        this.restaurantOpeningHourTuesday = restaurantOpeningHourTuesday;
        this.restaurantOpeningHourWednesday = restaurantOpeningHourWednesday;
        this.restaurantOpeningHourThursday = restaurantOpeningHourThursday;
        this.restaurantOpeningHourFriday = restaurantOpeningHourFriday;
        this.restaurantOpeningHourSaturday = restaurantOpeningHourSaturday;
        this.restaurantOpeningHourSunday = restaurantOpeningHourSunday;
    }

    /**
     * Gets RestaurantId.
     * @return restaurantId unique ID of the restaurant
     */
    public int getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets RestaurantId.
     * @param restaurantId unique ID of the restaurant
     */
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * Gets RestaurantPassword.
     * @return restaurantPassword password of the restaurant that complies with the ID
     */
    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    /**
     * Sets RestaurantPassword.
     * @param restaurantPassword password of the restaurant that complies with the ID
     */
    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword;
    }

    /**
     * Gets getRestaurantName.
     * @return restaurantName name of the restaurant
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Sets getRestaurantName.
     * @param restaurantName name of the restaurant
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Gets RestaurantEmail.
     * @return restaurantEmail Email address of the restaurant
     */
    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    /**
     * Sets RestaurantEmail.
     * @param restaurantEmail Email address of the restaurant
     */
    public void setRestaurantEmail(String restaurantEmail) {
        this.restaurantEmail = restaurantEmail;
    }

    /**
     * Gets RestaurantDisplayName.
     * @return restaurantDisplayName display name of the restaurant
     */
    public String getRestaurantDisplayName() {
        return restaurantDisplayName;
    }

    /**
     * Sets RestaurantDisplayName.
     * @param restaurantDisplayName display name of the restaurant
     */
    public void setRestaurantDisplayName(String restaurantDisplayName) {
        this.restaurantDisplayName = restaurantDisplayName;
    }

    /**
     * Gets RestaurantAddress.
     * @return restaurantAddress address of the restaurant
     */
    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    /**
     * Sets RestaurantAddress.
     * @param restaurantAddress address of the restaurant
     */
    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets RestaurantOpeningHourMonday.
     * @return restaurantOpeningHourMonday opening hours of the restaurant on Monday
     */
    public Date[] getRestaurantOpeningHourMonday() {
        return restaurantOpeningHourMonday;
    }

    /**
     * Sets RestaurantOpeningHourMonday.
     * @param restaurantOpeningHourMonday opening hours of the restaurant on Monday
     */
    public void setRestaurantOpeningHourMonday(Date[] restaurantOpeningHourMonday) {
        this.restaurantOpeningHourMonday = restaurantOpeningHourMonday;
    }

    /**
     * Gets RestaurantOpeningHourTuesday.
     * @return restaurantOpeningHourTuesday opening hours of the restaurant on Tuesday
     */
    public Date[] getRestaurantOpeningHourTuesday() {
        return restaurantOpeningHourTuesday;
    }

    /**
     * Sets RestaurantOpeningHourTuesday.
     * @param restaurantOpeningHourTuesday opening hours of the restaurant on Tuesday
     */
    public void setRestaurantOpeningHourTuesday(Date[] restaurantOpeningHourTuesday) {
        this.restaurantOpeningHourTuesday = restaurantOpeningHourTuesday;
    }

    /**
     * Gets RestaurantOpeningHourWednesday.
     * @return restaurantOpeningHourWednesday opening hours of the restaurant on Wednesday
     */
    public Date[] getRestaurantOpeningHourWednesday() {
        return restaurantOpeningHourWednesday;
    }

    /**
     * Sets RestaurantOpeningHourWednesday.
     * @param restaurantOpeningHourWednesday opening hours of the restaurant on Wednesday
     */
    public void setRestaurantOpeningHourWednesday(Date[] restaurantOpeningHourWednesday) {
        this.restaurantOpeningHourWednesday = restaurantOpeningHourWednesday;
    }

    /**
     * Gets RestaurantOpeningHourThursday.
     * @return restaurantOpeningHourThursday opening hours of the restaurant on Thursday
     */
    public Date[] getRestaurantOpeningHourThursday() {
        return restaurantOpeningHourThursday;
    }

    /**
     * Sets RestaurantOpeningHourThursday.
     * @param restaurantOpeningHourThursday opening hours of the restaurant on Thursday
     */
    public void setRestaurantOpeningHourThursday(Date[] restaurantOpeningHourThursday) {
        this.restaurantOpeningHourThursday = restaurantOpeningHourThursday;
    }

    /**
     * Gets RestaurantOpeningHourFriday.
     * @return restaurantOpeningHourFriday opening hours of the restaurant on Friday
     */
    public Date[] getRestaurantOpeningHourFriday() {
        return restaurantOpeningHourFriday;
    }

    /**
     * Sets RestaurantOpeningHourFriday.
     * @param restaurantOpeningHourFriday opening hours of the restaurant on Friday
     */
    public void setRestaurantOpeningHourFriday(Date[] restaurantOpeningHourFriday) {
        this.restaurantOpeningHourFriday = restaurantOpeningHourFriday;
    }

    /**
     * Gets RestaurantOpeningHourSaturday.
     * @return restaurantOpeningHourSaturday opening hours of the restaurant on Saturday
     */
    public Date[] getRestaurantOpeningHourSaturday() {
        return restaurantOpeningHourSaturday;
    }

    /**
     * Sets RestaurantOpeningHourSaturday.
     * @param restaurantOpeningHourSaturday opening hours of the restaurant on Saturday
     */
    public void setRestaurantOpeningHourSaturday(Date[] restaurantOpeningHourSaturday) {
        this.restaurantOpeningHourSaturday = restaurantOpeningHourSaturday;
    }

    /**
     * Gets RestaurantOpeningHourSunday.
     * @return restaurantOpeningHourSunday opening hours of the restaurant on Sunday
     */
    public Date[] getRestaurantOpeningHourSunday() {
        return restaurantOpeningHourSunday;
    }

    /**
     * Sets RestaurantOpeningHourSunday.
     * @param restaurantOpeningHourSunday opening hours of the restaurant on Sunday
     */
    public void setRestaurantOpeningHourSunday(Date[] restaurantOpeningHourSunday) {
        this.restaurantOpeningHourSunday = restaurantOpeningHourSunday;
    }
}
