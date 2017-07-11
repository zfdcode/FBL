package com.tum.fbl.core.persistence.healthdata;

public class HealthData {

    private int userId;

    private String deviceUserPassword;

    private int deviceUserId;

    private float burnedCalories;

    private float trackedCaloriesTimeRange;

    private float calorieGoal;

    /**
     *
     * @param userId the ID of the user referred to
     * @param deviceUserPassword
     * @param deviceUserId
     * @param burnedCalories amount of calories burnt
     * @param trackedCaloriesTimeRange time range the calories where tracked in
     * @param calorieGoal user's calorie goal
     */
    public HealthData(int userId, String deviceUserPassword, int deviceUserId, float burnedCalories, float trackedCaloriesTimeRange, float calorieGoal) {
        this.userId = userId;
        this.deviceUserPassword = deviceUserPassword;
        this.deviceUserId = deviceUserId;
        this.burnedCalories = burnedCalories;
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
        this.calorieGoal = calorieGoal;
    }

    /**
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return deviceUserPassword
     */
    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    /**
     *
     * @param deviceUserPassword
     */
    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }

    /**
     *
     * @return deviceUserId
     */
    public int getDeviceUserId() {
        return deviceUserId;
    }

    /**
     *
     * @param deviceUserId
     */
    public void setDeviceUserId(int deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    /**
     *
     * @return burnedCalories
     */
    public float getBurnedCalories() {
        return burnedCalories;
    }

    /**
     *
     * @param burnedCalories
     */
    public void setBurnedCalories(float burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    /**
     *
     * @return trackedCaloriesTimeRange
     */
    public float getTrackedCaloriesTimeRange() {
        return trackedCaloriesTimeRange;
    }

    /**
     *
     * @param trackedCaloriesTimeRange
     */
    public void setTrackedCaloriesTimeRange(float trackedCaloriesTimeRange) {
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
    }

    /**
     *
     * @return calorieGoal
     */
    public float getCalorieGoal() {
        return calorieGoal;
    }

    /**
     *
     * @param calorieGoal
     */
    public void setCalorieGoal(float calorieGoal) {
        this.calorieGoal = calorieGoal;
    }
}
