package com.tum.fbl.core.persistence.comment;

/**
 * Created by Malte on 26.06.2017.
 */
public class Comment {

    private int commendId;

    private String comment;

    public Comment(int commendId, String comment) {
        this.commendId = commendId;
        this.comment = comment;
    }

    public int getCommendId() {
        return commendId;
    }

    public void setCommendId(int commendId) {
        this.commendId = commendId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
