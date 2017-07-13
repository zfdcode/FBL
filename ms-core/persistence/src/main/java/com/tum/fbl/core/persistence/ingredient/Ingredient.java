package com.tum.fbl.core.persistence.ingredient;

public class Ingredient {

    private int ingredientId;

    private String ingredientName;

    private String description;

    private String ingredientImage;

    private float energy;

    private float totalFat;

    private float protein;

    private float totalCarbohydrate;

    private boolean isGarnish;

    private float sugar;

    /**
     *
     * @param ingredientId the ingredient's unique ID
     * @param ingredientName the ingredient's name
     * @param description description of the ingredient
     * @param ingredientImage URL to an image of the ingredient
     * @param energy the ingredient's energy
     * @param totalFat the ingredient's totalFat
     * @param protein the ingredient's protein
     * @param totalCarbohydrate the ingredient's totalCarbohydrate
     * @param isGarnish true of the ingredient is a garnish/side dish, false otherwise
     */

    public Ingredient(int ingredientId, String ingredientName, String description, String ingredientImage, float energy, float totalFat, float protein, float totalCarbohydrate, boolean isGarnish, float sugar) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.description = description;
        this.ingredientImage = ingredientImage;
        this.energy = energy;
        this.totalFat = totalFat;
        this.protein = protein;
        this.totalCarbohydrate = totalCarbohydrate;
        this.isGarnish = isGarnish;
        this.sugar = sugar;
    }

    /**
     * Gets ingredientId
     * @return ingredientId
     */
    public int getIngredientId() {
        return ingredientId;
    }

    /**
     * Sets ingredientId
     * @param ingredientId
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    /**
     * Gets ingredientName
     * @return ingredientName
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets ingredientName
     * @param ingredientName
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Gets description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets URL to ingredientImage
     * @return URL to ingredientImage
     */
    public String getIngredientImage() {
        return ingredientImage;
    }

    /**
     * Sets URL to ingredientImage
     * @param ingredientImage URL to ingredientImage
     */
    public void setIngredientImage(String ingredientImage) {
        this.ingredientImage = ingredientImage;
    }

    /**
     * Gets energy
     * @return energy
     */
    public float getEnergy() {
        return energy;
    }

    /**
     * Sets energy
     * @param energy
     */
    public void setEnergy(float energy) {
        this.energy = energy;
    }

    /**
     * Gets totalFat
     * @return totalFat
     */
    public float getTotalFat() {
        return totalFat;
    }

    /**
     * Sets totalFat
     * @param totalFat
     */
    public void setTotalFat(float totalFat) {
        this.totalFat = totalFat;
    }

    /**
     * Gets protein
     * @return protein
     */
    public float getProtein() {
        return protein;
    }

    /**
     * Sets protein
     * @param protein
     */
    public void setProtein(float protein) {
        this.protein = protein;
    }

    /**
     * Gets totalCarbohydrate
     * @return totalCarbohydrate
     */
    public float getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    /**
     * Sets totalCarbohydrate
     * @param totalCarbohydrate
     */
    public void setTotalCarbohydrate(float totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    /**
     * Gets isGarnish
     * @return isGarnish
     */
    public boolean isGarnish() {
        return isGarnish;
    }

    /**
     * Sets isGarnish
     * @param garnish
     */
    public void setGarnish(boolean garnish) {
        isGarnish = garnish;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }
}
