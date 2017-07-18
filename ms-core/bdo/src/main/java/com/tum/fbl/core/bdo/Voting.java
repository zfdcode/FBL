package com.tum.fbl.core.bdo;

import java.sql.Date;

/**
 * Documented by jie on 01.07.2017.
 */

public class Voting {
    private int votingId;

    private User createdBy;

    private Date createdOn;

    private Date startDate;

    private String location;

    public Voting(){};

    /**
     * Constructs Voting that specifies the activity of voting started by the organising user.
     * @param votingId unique ID of the voting action
     * @param createdBy the user that created the voting activity
     * @param createdOn the date when the voting activity is created
     * @param startDate the data when the voting activity starts
     * @param location the location where the voting activity takes place
     */
    public Voting(int votingId, Date createdOn, Date startDate, String location) {
        this.votingId = votingId;
        this.createdOn = createdOn;
        this.startDate = startDate;
        this.location = location;
    }

    /**
     * Gets VotingId.
     * @return votingId unique ID of the voting action
     */
    public int getVotingId() {
        return votingId;
    }

    /**
     * Sets VotingId.
     * @param votingId unique ID of the voting action
     */
    public void setVotingId(int votingId) {
        this.votingId = votingId;
    }

    /**
     * Gets CreatedBy.
     * @return createdBy the user that created the voting activity
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets CreatedBy.
     * @param createdBy the user that created the voting activity
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets CreatedOn.
     * @return createdOn the date when the voting activity is created
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets CreatedOn.
     * @param createdOn the date when the voting activity is created
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Gets StartDate.
     * @return startDate the data when the voting activity starts
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets StartDate.
     * @param startDate the data when the voting activity starts
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets Location.
     * @return location the location where the voting activity takes place
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets Location.
     * @param location the location where the voting activity takes place
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
