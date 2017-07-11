package com.tum.fbl.core.persistence.user;

import java.util.Date;

/**
 * Created by patrickmelchner on 12.06.17.
 */
public class User {

    private int userId;

    private String userName;

    private String userPassword;

    private String email;

    private Date birthday;

    private int height;

    private int weight;

    private String DisplayName;

    private String restaurantAddress;

    private float longitude;

    private float latitude;

    private int role;

    /**
     *
     * @param userId the user's unique ID
     * @param userName the user's chosen username
     * @param userPassword the user's password
     * @param email the user's email
     * @param birthday the user's birthday
     * @param height the user's height
     * @param weight the user's weight
     * @param displayName the name that is displayed in the app
     * @param restaurantAddress if the user is a restaurant, this is their address
     * @param longitude if the user is a restaurant, this is the longitude of their business
     * @param latitude it the user is a restaurant, this is the latitude of their business
     * @param role the user's role
     */
    public User(int userId, String userName, String userPassword, String email, Date birthday, int height, int weight, String displayName, String restaurantAddress, float longitude, float latitude, int role) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        DisplayName = displayName;
        this.restaurantAddress = restaurantAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.role = role;
    }

    /**
     * gets the userId
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * sets the userId
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * gets the userName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * sets the userName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * gets the userPassword
     * @return userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * sets the userPassword
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * gets email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets birthday
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * sets birthday
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * gets height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * sets height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * gets weight
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * sets weight
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * gets displayName
     * @return displayName
     */
    public String getDisplayName() {
        return DisplayName;
    }

    /**
     * sets displayName
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    /**
     * gets restaurantAddress
     * @return restaurantAdress
     */
    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    /**
     * sets restaurantAdress
     * @param restaurantAddress
     */
    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    /**
     * gets longitude
     * @return longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * sets longitude
     * @param longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * gets latitude
     * @return latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * sets latitude
     * @param latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * gets role
     * @return role
     */
    public int getRole() {
        return role;
    }

    /**
     * sets role
     * @param role
     */
    public void setRole(int role) {
        this.role = role;
    }
}
