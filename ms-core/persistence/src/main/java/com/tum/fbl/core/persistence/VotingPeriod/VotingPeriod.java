package com.tum.fbl.core.persistence.VotingPeriod;

import java.util.Date;

public class VotingPeriod {
    private int votingPeriodId;

    private Date startTime;

    private Date endTime;

    private Boolean isFinished;

    private int calendarWeek;

    public VotingPeriod(int votingPeriodId, Date startTime, Date endTime, Boolean isFinished, int calendarWeek) {
        this.votingPeriodId = votingPeriodId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isFinished = isFinished;
        this.calendarWeek = calendarWeek;
    }

    public int getVotingPeriodId() {
        return votingPeriodId;
    }

    public void setVotingPeriodId(int votingPeriodId) {
        this.votingPeriodId = votingPeriodId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date startDate) {
        this.endTime = endTime;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public int getCalendarWeek() {
        return calendarWeek;
    }

    public void setCalendarWeek(int calendarWeek) {
        this.calendarWeek = calendarWeek;
    }
}
