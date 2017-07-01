package com.tum.fbl.core.bdo;

/**
 * Created by patrickmelchner on 30.05.17.
 * Documented by jie on 25.06.2017.
 */
public class HealthData {

    private User user;

    private String deviceUserPassword;

    private int deviceUserId;

    private int currentHearthbeat;

    private int heartbeatTimeRange;

    private float trackedCalorieToday;

    private float trackedCaloriesTimeRange;

    private int averageHeartbeatTimeRange;

    /**
     * Constructs HealthData that are retrieved from wearable devices.
     * @param user the user connected with the device
     * @param deviceUserPassword the password of the user logged in on the wearable device
     * @param deviceUserId the unique ID of the user
     * @param currentHearthbeat real-time heart beat of the user wearing the wearable device
     * @param heartbeatTimeRange heart beat of the user wearing the wearable device within a certain time range
     * @param trackedCalorieToday tracked consumed calorie of the user wearing the wearable device in the day
     * @param trackedCaloriesTimeRange tracked consumed calorie of the user wearing the wearable device within a certain time range
     * @param averageHeartbeatTimeRange average heart beat of the user wearing the wearable device within a certain time range
     */

    public HealthData(User user, String deviceUserPassword, int deviceUserId, int currentHearthbeat, int heartbeatTimeRange, float trackedCalorieToday, float trackedCaloriesTimeRange, int averageHeartbeatTimeRange) {
        this.user = user;
        this.deviceUserPassword = deviceUserPassword;
        this.deviceUserId = deviceUserId;
        this.currentHearthbeat = currentHearthbeat;
        this.heartbeatTimeRange = heartbeatTimeRange;
        this.trackedCalorieToday = trackedCalorieToday;
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
        this.averageHeartbeatTimeRange = averageHeartbeatTimeRange;
    }

    /**
     * Gets User.
     * @return user the user connected with the device
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user profile.
     * @param user the user connected with the device
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets DeviceUserPassword.
     * @return deviceUserPassword that complies with the userID of the device
     */
    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    /**
     * Sets DeviceUserPassword.
     * @param deviceUserPassword the password of the user logged in on the wearable device
     */
    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }

    /**
     * Gets DeviceUserId.
     * @return deviceUserId that complies with the UserID used in the wearable device APP
     */
    public int getDeviceUserId() {
        return deviceUserId;
    }

    /**
     * Sets DeviceUserId.
     * @param deviceUserId the unique ID of the user
     */
    public void setDeviceUserId(int deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    /**
     * Gets CurrentHearthbeat.
     * @return currentHearthbeat real-time heart beat of the user wearing the wearable device
     */
    public int getCurrentHearthbeat() {
        return currentHearthbeat;
    }

    /**
     * Sets CurrentHearthbeat.
     * @param currentHearthbeat real-time heart beat of the user wearing the wearable device
     */
    public void setCurrentHearthbeat(int currentHearthbeat) {
        this.currentHearthbeat = currentHearthbeat;
    }

    /**
     * Gets HeartbeatTimeRange.
     * @return heartbeatTimeRange heart beat of the user wearing the wearable device within a certain time range
     */
    public int getHeartbeatTimeRange() {
        return heartbeatTimeRange;
    }

    /**
     * Sets HeartbeatTimeRange.
     * @param heartbeatTimeRange heart beat of the user wearing the wearable device within a certain time range
     */
    public void setHeartbeatTimeRange(int heartbeatTimeRange) {
        this.heartbeatTimeRange = heartbeatTimeRange;
    }

    /**
     * Gets TrackedCalorieToday.
     * @return trackedCalorieToday tracked consumed calorie of the user wearing the wearable device in the day
     */
    public float getTrackedCalorieToday() {
        return trackedCalorieToday;
    }

    /**
     * Sets TrackedCalorieToday.
     * @param trackedCalorieToday tracked consumed calorie of the user wearing the wearable device in the day
     */
    public void setTrackedCalorieToday(float trackedCalorieToday) {
        this.trackedCalorieToday = trackedCalorieToday;
    }

    /**
     * Gets TrackedCaloriesTimeRange.
     * @return trackedCaloriesTimeRange tracked consumed calorie of the user wearing the wearable device within a certain time range
     */
    public float getTrackedCaloriesTimeRange() {
        return trackedCaloriesTimeRange;
    }

    /**
     * Sets TrackedCaloriesTimeRange.
     * @param trackedCaloriesTimeRange tracked consumed calorie of the user wearing the wearable device within a certain time range
     */
    public void setTrackedCaloriesTimeRange(float trackedCaloriesTimeRange) {
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
    }

    /**
     * Gets AverageHeartbeatTimeRange.
     * @return averageHeartbeatTimeRange average heart beat of the user wearing the wearable device within a certain time range
     */
    public int getAverageHeartbeatTimeRange() {
        return averageHeartbeatTimeRange;
    }

    /**
     * Sets AverageHeartbeatTimeRange.
     * @param averageHeartbeatTimeRange average heart beat of the user wearing the wearable device within a certain time range
     */
    public void setAverageHeartbeatTimeRange(int averageHeartbeatTimeRange) {
        this.averageHeartbeatTimeRange = averageHeartbeatTimeRange;
    }
}
