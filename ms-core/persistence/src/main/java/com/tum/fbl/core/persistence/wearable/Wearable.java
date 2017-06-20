package com.tum.fbl.core.persistence.wearable;

import java.sql.Date;

public class Wearable {

    private int deviceId;

    private int diviceType;

    private Date connectionTime;

    private Date exitTime;

    private int deviceUserId;

    private String deviceUserPassword;

    public Wearable(int deviceId, int diviceType, Date connectionTime, Date exitTime, int deviceUserId, String deviceUserPassword) {
        this.deviceId = deviceId;
        this.diviceType = diviceType;
        this.connectionTime = connectionTime;
        this.exitTime = exitTime;
        this.deviceUserId = deviceUserId;
        this.deviceUserPassword = deviceUserPassword;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
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

    public int getDeviceUserId() {
        return deviceUserId;
    }

    public void setDeviceUserId(int deviceUserId) {
        this.deviceUserId = deviceUserId;
    }

    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }
}