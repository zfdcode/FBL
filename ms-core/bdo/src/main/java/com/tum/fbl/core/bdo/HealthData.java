package com.tum.fbl.core.bdo;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class HealthData {

    private User user;

    private String device_user_password;

    private String device_user_id;

    private int current_hearthbeat;

    private int heartbeat_in_a_time_range;

    private float tracked_calorie_today;

    private float tracked_calories_in_a_time_range;

    private int average_heartbeat_in_a_time_range;

    public HealthData(User user, String device_user_password, String device_user_id, int current_hearthbeat, int heartbeat_in_a_time_range, float tracked_calorie_today, float tracked_calories_in_a_time_range, int average_heartbeat_in_a_time_range) {
        this.user = user;
        this.device_user_password = device_user_password;
        this.device_user_id = device_user_id;
        this.current_hearthbeat = current_hearthbeat;
        this.heartbeat_in_a_time_range = heartbeat_in_a_time_range;
        this.tracked_calorie_today = tracked_calorie_today;
        this.tracked_calories_in_a_time_range = tracked_calories_in_a_time_range;
        this.average_heartbeat_in_a_time_range = average_heartbeat_in_a_time_range;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDevice_user_password() {
        return device_user_password;
    }

    public void setDevice_user_password(String device_user_password) {
        this.device_user_password = device_user_password;
    }

    public String getDevice_user_id() {
        return device_user_id;
    }

    public void setDevice_user_id(String device_user_id) {
        this.device_user_id = device_user_id;
    }

    public int getCurrent_hearthbeat() {
        return current_hearthbeat;
    }

    public void setCurrent_hearthbeat(int current_hearthbeat) {
        this.current_hearthbeat = current_hearthbeat;
    }

    public int getHeartbeat_in_a_time_range() {
        return heartbeat_in_a_time_range;
    }

    public void setHeartbeat_in_a_time_range(int heartbeat_in_a_time_range) {
        this.heartbeat_in_a_time_range = heartbeat_in_a_time_range;
    }

    public float getTracked_calorie_today() {
        return tracked_calorie_today;
    }

    public void setTracked_calorie_today(float tracked_calorie_today) {
        this.tracked_calorie_today = tracked_calorie_today;
    }

    public float getTracked_calories_in_a_time_range() {
        return tracked_calories_in_a_time_range;
    }

    public void setTracked_calories_in_a_time_range(float tracked_calories_in_a_time_range) {
        this.tracked_calories_in_a_time_range = tracked_calories_in_a_time_range;
    }

    public int getAverage_heartbeat_in_a_time_range() {
        return average_heartbeat_in_a_time_range;
    }

    public void setAverage_heartbeat_in_a_time_range(int average_heartbeat_in_a_time_range) {
        this.average_heartbeat_in_a_time_range = average_heartbeat_in_a_time_range;
    }
}
