package com.tum.fbl.core.bdo;

/**
 * Created by patrickmelchner on 30.05.17.
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getCurrentHearthbeat() {
        return currentHearthbeat;
    }

    public void setCurrentHearthbeat(int currentHearthbeat) {
        this.currentHearthbeat = currentHearthbeat;
    }

    public int getHeartbeatTimeRange() {
        return heartbeatTimeRange;
    }

    public void setHeartbeatTimeRange(int heartbeatTimeRange) {
        this.heartbeatTimeRange = heartbeatTimeRange;
    }

    public float getTrackedCalorieToday() {
        return trackedCalorieToday;
    }

    public void setTrackedCalorieToday(float trackedCalorieToday) {
        this.trackedCalorieToday = trackedCalorieToday;
    }

    public float getTrackedCaloriesTimeRange() {
        return trackedCaloriesTimeRange;
    }

    public void setTrackedCaloriesTimeRange(float trackedCaloriesTimeRange) {
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
    }

    public int getAverageHeartbeatTimeRange() {
        return averageHeartbeatTimeRange;
    }

    public void setAverageHeartbeatTimeRange(int averageHeartbeatTimeRange) {
        this.averageHeartbeatTimeRange = averageHeartbeatTimeRange;
    }
}
