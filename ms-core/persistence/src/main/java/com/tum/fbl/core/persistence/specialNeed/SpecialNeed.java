package com.tum.fbl.core.persistence.specialNeed;

public class SpecialNeed {

    private String specialNeedId;

    private String specialNeedName;

    public SpecialNeed(String specialNeedId, String specialNeedName) {
        this.specialNeedId = specialNeedId;
        this.specialNeedName = specialNeedName;
    }

    public String getSpecialNeedId() {
        return specialNeedId;
    }

    public void setSpecialNeedId(String specialNeedId) {
        this.specialNeedId = specialNeedId;
    }

    public String getSpecialNeedName() {
        return specialNeedName;
    }

    public void setSpecialNeedName(String specialNeedName) {
        this.specialNeedName = specialNeedName;
    }
}