package com.tum.fbl.core.bdo;

import java.util.Date;


public class User {

    private int user_id;

    private String user_name;

    private String user_password;

    private String email;

    private Date birthday;

    private int height;

    private int weight;

    private int role;

    public User(int user_id, String user_name, String user_password, String email, Date birthday, int height, int weight, int role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.email = email;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
