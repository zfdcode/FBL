package com.tum.fbl.core.persistence.ingredient;

public class Ingredient {

    private int ingredientId;

    private String ingredientName;

    private String description;

    private byte[] ingredientImage;

    private float energy;

    private float totalFat;

    private float protein;

    private float totalCarbohydrate;

    private String[] tag;

    public Ingredient(int ingredientId, String ingredientName, String description, byte[] ingredientImage, float energy, float totalFat, float protein, float totalCarbohydrate) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.description = description;
        this.ingredientImage = ingredientImage;
        this.energy = energy;
        this.totalFat = totalFat;
        this.protein = protein;
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getIngredientImage() {
        return ingredientImage;
    }

    public void setIngredientImage(byte[] ingredientImage) {
        this.ingredientImage = ingredientImage;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(float totalFat) {
        this.totalFat = totalFat;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public void setTotalCarbohydrate(float totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }
}
