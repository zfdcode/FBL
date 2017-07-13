package com.tum.fbl.core.bdo;

import java.util.Date;
import java.util.List;

/**
 * Created by MS on 10.07.2017.
 */
public class VotingPeriod {

    private int votingPeriodId;

    private Date startTime;

    private Date endTime;

    private Boolean isFinished;

    private int calendarWeek;

    private VotingIngItem[] VotingIngItems;

    public VotingPeriod(int votingPeriodId, Date startTime, Date endTime, Boolean isFinished, int calendarWeek, VotingIngItem[] votingIngItems) {
        this.votingPeriodId = votingPeriodId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isFinished = isFinished;
        this.calendarWeek = calendarWeek;
        VotingIngItems = votingIngItems;
    }

    public VotingPeriod(com.tum.fbl.core.persistence.VotingPeriod.VotingPeriod votingPeriod) {
        this.votingPeriodId = votingPeriod.getVotingPeriodId();
        this.startTime = votingPeriod.getStartTime();
        this.endTime = votingPeriod.getEndTime();
        this.isFinished = votingPeriod.getIsFinished();
        this.calendarWeek = votingPeriod.getCalendarWeek();
        VotingIngItems = new VotingIngItem[0];
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

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public int getCalendarWeek() {
        return calendarWeek;
    }

    public void setCalendarWeek(int calendarWeek) {
        this.calendarWeek = calendarWeek;
    }

    public VotingIngItem[]  getVotingIngItems() {
        return VotingIngItems;
    }

    public void setVotingIngItems(VotingIngItem[]  votingIngItems) {
        VotingIngItems = votingIngItems;
    }


}
