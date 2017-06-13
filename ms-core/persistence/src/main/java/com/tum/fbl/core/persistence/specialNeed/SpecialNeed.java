package com.tum.fbl.core.persistence.specialNeed;

public class SpecialNeed {

    private String special_need_id;

    private String special_need_name;

    public SpecialNeed(String special_need_id, String special_need_name) {
        this.special_need_id = special_need_id;
        this.special_need_name = special_need_name;
    }

    public String getSpecial_need_id() {
        return special_need_id;
    }

    public void setSpecial_need_id(String special_need_id) {
        this.special_need_id = special_need_id;
    }

    public String getSpecial_need_name() {
        return special_need_name;
    }

    public void setSpecial_need_name(String special_need_name) {
        this.special_need_name = special_need_name;
    }
}