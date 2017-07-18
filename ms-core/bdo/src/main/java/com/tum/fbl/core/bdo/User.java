package com.tum.fbl.core.bdo;

import java.sql.Date;

/**
 * Documented by jie on 01.07.2017.
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

    private int role;


    public User() {
    }

    public User(int userId, String userName, String userPassword, String email, Date birthday, int height, int weight, String displayName, int role) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        DisplayName = displayName;
        this.role = role;
    }


    public User(com.tum.fbl.core.persistence.user.User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.DisplayName = user.getDisplayName();
        this.role = user.getRole();
    }
    /**
     * Gets UserId.
     * @return userId unique ID of the user
     */

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}