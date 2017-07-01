package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by patrickmelchner on 30.05.17.
 * Documented by jie on 01.07.2017.
 */
public class Wearable {

    private int deviceId;

    private int diviceType;

    private Date connectionTime;

    private Date exitTime;

    private User user;

    private String deviceUserPassword;

    /**
     * Constructs Wearable that is connected with the user and the APP.
     * @param deviceId unique ID of the device
     * @param diviceType type of the device
     * @param connectionTime time when the device connects the APP
     * @param exitTime exit time of the device
     * @param user user logged in with the device
     * @param deviceUserPassword user password of the user on the device
     */
    public Wearable(int deviceId, int diviceType, Date connectionTime, Date exitTime, User user, String deviceUserPassword) {
        this.deviceId = deviceId;
        this.diviceType = diviceType;
        this.connectionTime = connectionTime;
        this.exitTime = exitTime;
        this.user = user;
        this.deviceUserPassword = deviceUserPassword;
    }

    /**
     * Gets DeviceId.
     * @return deviceId unique ID of the device
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * Sets DeviceId.
     * @param deviceId unique ID of the device
     */
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets DiviceType.
     * @return diviceType type of the device
     */
    public int getDiviceType() {
        return diviceType;
    }

    /**
     * Sets DiviceType.
     * @param diviceType type of the device
     */
    public void setDiviceType(int diviceType) {
        this.diviceType = diviceType;
    }

    /**
     * Gets ConnectionTime.
     * @return connectionTime time when the device connects the APP
     */
    public Date getConnectionTime() {
        return connectionTime;
    }

    /**
     * Sets ConnectionTime.
     * @param connectionTime time when the device connects the APP
     */
    public void setConnectionTime(Date connectionTime) {
        this.connectionTime = connectionTime;
    }

    /**
     * Gets ExitTime.
     * @return exitTime exit time of the device
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * Sets ExitTime.
     * @param exitTime exit time of the device
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * Gets User.
     * @return user user logged in with the device
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets User.
     * @param user user logged in with the device
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets DeviceUserPassword.
     * @return deviceUserPassword user password of the user on the device
     */
    public String getDeviceUserPassword() {
        return deviceUserPassword;
    }

    /**
     * Sets DeviceUserPassword.
     * @param deviceUserPassword user password of the user on the device
     */
    public void setDeviceUserPassword(String deviceUserPassword) {
        this.deviceUserPassword = deviceUserPassword;
    }
}
