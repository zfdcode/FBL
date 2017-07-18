package com.tum.fbl.core.persistence.voting;

import java.sql.Date;

public class Voting {
    private int votingId;

    private int createdBy;

    private Date createdOn;

    private Date startDate;

    private String location;

    /**
     *
     * @param votingId the voting's unique ID
     * @param createdBy the unique ID of the user who created the voting
     * @param createdOn the date this voting was created on
     * @param startDate the date this voting started
     * @param location the location this voting has been placed
     */
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
