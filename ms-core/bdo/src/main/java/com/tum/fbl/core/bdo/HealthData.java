package com.tum.fbl.core.bdo;

/**
 * Created by patrickmelchner on 30.05.17.
 * Documented by jie on 25.06.2017.
 */
public class HealthData {

    private int userId;

    private String deviceUserPassword;

    private int deviceUserId;

    private float burnedCalorie;

    private float trackedCaloriesTimeRange;

    private float calorieGoal;

    /**
     * Constructs HealthData that are retrieved from wearable devices.
     * @param deviceUserPassword the password of the user logged in on the wearable device
     * @param deviceUserId the unique ID of the user
     * @param trackedCaloriesTimeRange tracked consumed calorie of the user wearing the wearable device within a certain time range
     */

    public HealthData(int userId, String deviceUserPassword, int deviceUserId, float burnedCalorie, float trackedCaloriesTimeRange, float calorieGoal) {
        this.userId = userId;
        this.deviceUserPassword = deviceUserPassword;
        this.deviceUserId = deviceUserId;
        this.burnedCalorie = burnedCalorie;
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
        this.calorieGoal = calorieGoal;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }

    public int getDeviceUserId() {
        return deviceUserId;
    }

    public void setDeviceUserId(int deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    public float getBurnedCalorie() {
        return burnedCalorie;
    }

    public void setBurnedCalorie(float burnedCalorie) {
        this.burnedCalorie = burnedCalorie;
    }

    public float getTrackedCaloriesTimeRange() {
        return trackedCaloriesTimeRange;
    }

    public void setTrackedCaloriesTimeRange(float trackedCaloriesTimeRange) {
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
    }

    public float getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(float calorieGoal) {
        this.calorieGoal = calorieGoal;
    }
}
