package com.tum.fbl.core.bdo;

/**
 * Created by zfngd on 2017/6/4.
 */
public class SpecialNeed {

    private int special_need_id;

    private String special_need_name;

    public SpecialNeed(int special_need_id, String special_need_name) {
        this.special_need_id = special_need_id;
        this.special_need_name = special_need_name;
    }

    public int getSpecial_need_id() {
        return special_need_id;
    }

    public void setSpecial_need_id(int special_need_id) {
        this.special_need_id = special_need_id;
    }

    public String getSpecial_need_name() {
        return special_need_name;
    }

    public void setSpecial_need_name(String special_need_name) {
        this.special_need_name = special_need_name;
    }
}
