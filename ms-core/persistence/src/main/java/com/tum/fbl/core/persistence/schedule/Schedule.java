package com.tum.fbl.core.persistence.schedule;

import java.sql.Date;


public class Schedule {

    private String userId;

    private int schedulesDayOfTheWeek;

    private Date schedulesOpeningTime;

    private Date schedulesClosingTime;

    /**
     *
     * @param userId the restaurant's userId
     * @param schedulesDayOfTheWeek
     * @param schedulesOpeningTime
     * @param schedulesClosingTime
     */
    public Schedule(String userId, int schedulesDayOfTheWeek, Date schedulesOpeningTime, Date schedulesClosingTime) {
        this.userId = userId;
        this.schedulesDayOfTheWeek = schedulesDayOfTheWeek;
        this.schedulesOpeningTime = schedulesOpeningTime;
        this.schedulesClosingTime = schedulesClosingTime;
    }

    /**
     * gets the userId
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * sets the userId
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * gets schedulesDayOfTheWeek
     * @return schedulesDayOfTheWeek
     */
    public int getSchedulesDayOfTheWeek() {
        return schedulesDayOfTheWeek;
    }

    /**
     * sets schedulesDayOfTheWeek
     * @param schedulesDayOfTheWeek
     */
    public void setSchedulesDayOfTheWeek(int schedulesDayOfTheWeek) {
        this.schedulesDayOfTheWeek = schedulesDayOfTheWeek;
    }

    /**
     * gets schedulesOpeningTime
     * @return schedulesOpeningTime
     */
    public Date getSchedulesOpeningTime() {
        return schedulesOpeningTime;
    }

    /**
     * sets schedulesOpeningTime
     * @param schedulesOpeningTime
     */
    public void setSchedulesOpeningTime(Date schedulesOpeningTime) {
        this.schedulesOpeningTime = schedulesOpeningTime;
    }

    /**
     * gets schedulesClosingTime
     * @return schedulesClosingTime
     */
    public Date getSchedulesClosingTime() {
        return schedulesClosingTime;
    }

    /**
     * sets schedulesClosingTime
     * @param schedulesClosingTime
     */
    public void setSchedulesClosingTime(Date schedulesClosingTime) {
        this.schedulesClosingTime = schedulesClosingTime;
    }
}
