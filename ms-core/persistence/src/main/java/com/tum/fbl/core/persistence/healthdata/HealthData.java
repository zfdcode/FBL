package com.tum.fbl.core.persistence.healthdata;

public class HealthData {

    private int userId;

    private String deviceUserPassword;

    private int deviceUserId;

    private float burnedCalorie;

    private float trackedCaloriesTimeRange;

    private float calorieGoal;

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
