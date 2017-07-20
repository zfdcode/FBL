package com.tum.fbl.core.bdo;

import java.util.Date;

/**
 * Created by MS on 14.07.2017.
 */
public class VotingOrderList {

    private int votingOrderListId;

    private float orderedAmount;

    private Date orderedAt;

    private int votingPeriodId;

    private int ingredientId;

    public  VotingOrderList(){}

    public VotingOrderList(int votingOrderListId, float orderedAmount, Date orderedAt, int votingPeriodId, int ingredientId) {
        this.votingOrderListId = votingOrderListId;
        this.orderedAmount = orderedAmount;
        this.orderedAt = orderedAt;
        this.votingPeriodId = votingPeriodId;
        this.ingredientId = ingredientId;
    }

    public VotingOrderList(com.tum.fbl.core.persistence.VotingOrderList.VotingOrderList votingOrderList){
        this.votingOrderListId = votingOrderList.getVotingOrderListId();
        this.orderedAmount = votingOrderList.getOrderedAmount();
        this.orderedAt = votingOrderList.getOrderedAt();
        this.votingPeriodId = votingOrderList.getVotingPeriodId();
        this.ingredientId = votingOrderList.getIngredientId();
    }

    public int getVotingOrderListId() {
        return votingOrderListId;
    }

    public void setVotingOrderListId(int votingOrderListId) {
        this.votingOrderListId = votingOrderListId;
    }

    public float getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(float orderedAmount) {
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

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}
