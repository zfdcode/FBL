package com.tum.fbl.core.bdo;

/**
 * Created by zfngd on 2017/6/4.
 * Documented by jie on 25.06.2017.
 */
public class Ingredient {

    private int ingredientId;

    private String ingredientName;

    private String description;

    private String ingredientImage;

    private float energy;

    private float totalFat;

    private float protein;

    private float totalCarbohydrate;

    private String[] tag;

    private float sugar;

    private boolean isGarnish;

    public Ingredient(){

    }

    /**
     * Constructs Ingredient that are used in the meal offered in Mensa.
     * @param ingredientId unique ID of the ingredient used in Mensa
     * @param ingredientName name of the ingredient used in Mensa
     * @param description description of the ingredient used in Mensa
     * @param ingredientImage image of the ingredient used in Mensa
     * @param energy energy of the ingredient used in Mensa
     * @param totalFat total fat of the ingredient used in Mensa
     * @param protein protein of the ingredient used in Mensa
     * @param totalCarbohydrate total carbohydrate of the ingredient used in Mensa
     * @param tag tag of the ingredient used in Mensa
     */
    public Ingredient(int ingredientId, String ingredientName, String description, String ingredientImage, float energy, float totalFat, float protein, float totalCarbohydrate, String[] tag, float sugar) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.description = description;
        this.ingredientImage = ingredientImage;
        this.energy = energy;
        this.totalFat = totalFat;
        this.protein = protein;
        this.totalCarbohydrate = totalCarbohydrate;
        this.tag = tag;
        this.sugar = sugar;
    }

    /**
     *
     * @param ingredient
     */
    public Ingredient(com.tum.fbl.core.persistence.ingredient.Ingredient ingredient) {
        this.ingredientId = ingredient.getIngredientId();
        this.ingredientName = ingredient.getIngredientName();
        this.description = ingredient.getDescription();
        this.ingredientImage = ingredient.getIngredientImage();
        this.energy = ingredient.getEnergy();
        this.totalFat = ingredient.getTotalFat();
        this.protein = ingredient.getProtein();
        this.totalCarbohydrate = ingredient.getTotalCarbohydrate();
        //this.tag = IngredientTag.getTags();
        this.sugar = ingredient.getSugar();
    }

    /**
     * Gets IngredientId.
     * @return ingredientId unique ID of the ingredient used in Mensa
     */
    public int getIngredientId() {
        return ingredientId;
    }

    /**
     * Sets IngredientId.
     * @param ingredientId unique ID of the ingredient used in Mensa
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    /**
     * Gets IngredientName.
     * @return ingredientName name of the ingredient used in Mensa
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets IngredientName.
     * @param ingredientName name of the ingredient used in Mensa
     */
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Gets Description.
     * @return description description of the ingredient used in Mensa
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets Description.
     * @param description description of the ingredient used in Mensa
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets IngredientImage.
     * @return ingredientImage image of the ingredient used in Mensa
     */
    public String getIngredientImage() {
        return ingredientImage;
    }

    /**
     * Sets IngredientImage
     * @param ingredientImage image of the ingredient used in Mensa
     */
    public void setIngredientImage(String ingredientImage) {
        this.ingredientImage = ingredientImage;
    }

    /**
     * Gets Energy.
     * @return energy energy of the ingredient used in Mensa
     */
    public float getEnergy() {
        return energy;
    }

    /**
     * Sets Energy.
     * @param energy energy of the ingredient used in Mensa
     */
    public void setEnergy(float energy) {
        this.energy = energy;
    }

    /**
     * Gets TotalFat.
     * @return totalFat total fat of the ingredient used in Mensa
     */
    public float getTotalFat() {
        return totalFat;
    }

    /**
     * Sets TotalFat.
     * @param totalFat total fat of the ingredient used in Mensa
     */
    public void setTotalFat(float totalFat) {
        this.totalFat = totalFat;
    }

    /**
     * Gets Protein.
     * @return protein protein of the ingredient used in Mensa
     */
    public float getProtein() {
        return protein;
    }

    /**
     * Sets Protein.
     * @param protein protein of the ingredient used in Mensa
     */
    public void setProtein(float protein) {
        this.protein = protein;
    }

    /**
     * Gets TotalCarbohydrate.
     * @return totalCarbohydrate total carbohydrate of the ingredient used in Mensa
     */
    public float getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    /**
     * Sets TotalCarbohydrate.
     * @param totalCarbohydrate total carbohydrate of the ingredient used in Mensa
     */
    public void setTotalCarbohydrate(float totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    /**
     * Gets Tag.
     * @return tag tag of the ingredient used in Mensa
     */
    public String[] getTag() {
        return tag;
    }

    /**
     * Sets Tag.
     * @param tag tag of the ingredient used in Mensa
     */
    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public boolean isGarnish() {
        return isGarnish;
    }

    public void setGarnish(boolean garnish) {
        isGarnish = garnish;
    }
}
