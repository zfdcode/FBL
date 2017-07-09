package com.tum.fbl.core.persistence.VotingOrderList;

import java.util.Date;

public class VotingOrderList {
    private int votingOrderListId;

    private float orderedAmount;

    private Date orderedAt;

    private int votingPeriodId;


    public VotingOrderList(int votingOrderListId, float orderedAmount, Date orderedAt, int votingPeriodId) {
        this.votingOrderListId = votingOrderListId;
        this.orderedAmount = orderedAmount;
        this.orderedAt = orderedAt;
        this.votingPeriodId = votingPeriodId;
    }

    public int getVotingOrderListId() {
        return votingOrderListId;
    }

    public void setVotingOrderListId(int votingOrderListId) {
        this.votingOrderListId = votingOrderListId;
    }

    public Float getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(Float orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public int getVotingPeriodId() {
        return votingPeriodId;
    }

    public void setVotingPeriodId(int votingPeriodId) {
        this.votingPeriodId = votingPeriodId;
    }

}
