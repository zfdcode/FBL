package com.tum.fbl.core.persistence.wearable;

public class Wearable {

    private String deviceId;

    private int diviceType;

    private Date connectionTime;

    private Date exitTime;

    private String deviceUserId;

    private String deviceUserPassword;

    public Wearable(String deviceId, int diviceType, Date connectionTime, Date exitTime, String deviceUserId, String deviceUserPassword) {
        this.deviceId = deviceId;
        this.diviceType = diviceType;
        this.connectionTime = connectionTime;
        this.exitTime = exitTime;
        this.deviceUserId = deviceUserId;
        this.deviceUserPassword = deviceUserPassword;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getDiviceType() {
        return diviceType;
    }

    public void setDiviceType(int diviceType) {
        this.diviceType = diviceType;
    }

    public Date getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(Date connectionTime) {
        this.connectionTime = connectionTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public String getDeviceUserId() {
        return deviceUserId;
    }

    public void setDeviceUserId(String deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }
}