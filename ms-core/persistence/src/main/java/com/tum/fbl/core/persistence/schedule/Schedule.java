package com.tum.fbl.core.persistence.schedule;

import java.util.Date;


public class Schedules {

    private int userId;

    private int schedulesDayOfTheWeek;

    private Date schedulesOpeningTime;

    private Date schedulesClosingTime;

    public Schedules(String userId, int schedulesDayOfTheWeek, Date schedulesOpeningTime, Date schedulesClosingTime) {
        this.userId = userId;
        this.schedulesDayOfTheWeek = schedulesDayOfTheWeek;
        this.schedulesOpeningTime = schedulesOpeningTime;
        this.schedulesClosingTime = schedulesClosingTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSchedulesDayOfTheWeek() {
        return schedulesDayOfTheWeek;
    }

    public void setSchedulesDayOfTheWeek(int schedulesDayOfTheWeek) {
        this.schedulesDayOfTheWeek = schedulesDayOfTheWeek;
    }

    public Date getSchedulesOpeningTime() {
        return schedulesOpeningTime;
    }

    public void setSchedulesOpeningTime(Date schedulesOpeningTime) {
        this.schedulesOpeningTime = schedulesOpeningTime;
    }

    public Date getSchedulesClosingTime() {
        return schedulesClosingTime;
    }

    public void setSchedulesClosingTime(Date schedulesClosingTime) {
        this.schedulesClosingTime = schedulesClosingTime;
    }
}
