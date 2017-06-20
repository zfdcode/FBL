package com.tum.fbl.core.bdo;

public class Voting {
    private int votingId;

    private int createdBy;

    private Date createdOn;

    private Date startDate;

    private String location;

    public Voting(int votingId, int createdBy, Date createdOn, Date startDate, String location) {
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
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
