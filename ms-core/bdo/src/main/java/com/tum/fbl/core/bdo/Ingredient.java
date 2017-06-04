package com.tum.fbl.core.bdo;

/**
 * Created by zfngd on 2017/6/4.
 */
public class Ingredient {

    private int ingredient_id;

    private String ingredient_name;

    public Ingredient(int ingredient_id, String ingredient_name) {
        this.ingredient_id = ingredient_id;
        this.ingredient_name = ingredient_name;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
