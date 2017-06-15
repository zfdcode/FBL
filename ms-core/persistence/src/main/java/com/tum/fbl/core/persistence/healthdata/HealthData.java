package com.tum.fbl.core.persistence.healthdata;

public class HealthData {

    private String userId;

    private String deviceUserPassword;

    private String deviceUserId;

    private int currentHearthbeat;

    private int heartbeatTimeRange;

    private float trackedCalorieToday;

    private float trackedCaloriesTimeRange;

    private int averageHeartbeatTimeRange;

    public HealthData(String userId, String deviceUserPassword, String deviceUserId, int currentHearthbeat, int heartbeatTimeRange, float trackedCalorieToday, float trackedCaloriesTimeRange, int averageHeartbeatTimeRange) {
        this.userId = userId;
        this.deviceUserPassword = deviceUserPassword;
        this.deviceUserId = deviceUserId;
        this.currentHearthbeat = currentHearthbeat;
        this.heartbeatTimeRange = heartbeatTimeRange;
        this.trackedCalorieToday = trackedCalorieToday;
        this.trackedCaloriesTimeRange = trackedCaloriesTimeRange;
        this.averageHeartbeatTimeRange = averageHeartbeatTimeRange;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }

    public String getDeviceUserId() {
        return deviceUserId;
    }

    public void setDeviceUserId(String deviceUserId) {
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
