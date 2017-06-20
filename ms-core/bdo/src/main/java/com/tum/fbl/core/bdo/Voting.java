package com.tum.fbl.core.bdo;

public class Voting {
    private int votingId;

    private User createdBy;

    private Date createdOn;

    private Date startDate;

    private String location;

    public Voting(int votingId, User createdBy, Date createdOn, Date startDate, String location) {
        this.votingId = votingId;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.startDate = startDate;
        this.location = location;
    }

    public int getVotingId() {
        return votingId;
    }

    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
