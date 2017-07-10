package com.tum.fbl.core.bdo;

import java.util.Date;

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

    private String role;

    /**
     * Constructs User that specifies the user of the APP in terms of name, password, email, birthday, height and weight.
     * @param userId unique ID of the user
     * @param userName name of the user
     * @param userPassword password of the user that complies with the ID
     * @param email email address of the user
     * @param birthday birthday of the user
     * @param height height of the user
     * @param weight weight of the user
     */
    public User(int userId, String userName, String userPassword, String email, Date birthday, int height, int weight) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Gets UserId.
     * @return userId unique ID of the user
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets UserId.
     * @param userId unique ID of the user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets UserName.
     * @return userName name of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets UserName.
     * @param userName name of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets UserPassword.
     * @return userPassword password of the user that complies with the ID
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets UserPassword.
     * @param userPassword password of the user that complies with the ID
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets Email.
     * @return email email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Email.
     * @param email email address of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets Birthday.
     * @return birthday birthday of the user
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets Birthday.
     * @param birthday birthday of the user
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets Height.
     * @return height height of the user
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets Height.
     * @param height height of the user
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets Weight.
     * @return weight weight of the user
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets Weight.
     * @param weight weight of the user
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }
    


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
