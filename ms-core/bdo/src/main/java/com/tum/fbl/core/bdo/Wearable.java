package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 */
public class Wearable {

    private int deviceId;

    private int diviceType;

    private Date connectionTime;

    private Date exitTime;

    private User user;

    private String deviceUserPassword;

    public Wearable(int deviceId, int diviceType, Date connectionTime, Date exitTime, User user, String deviceUserPassword) {
        this.deviceId = deviceId;
        this.diviceType = diviceType;
        this.connectionTime = connectionTime;
        this.exitTime = exitTime;
        this.user = user;
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
}
