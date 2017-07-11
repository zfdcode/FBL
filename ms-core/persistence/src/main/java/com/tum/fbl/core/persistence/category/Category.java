package com.tum.fbl.core.persistence.category;

public class Category {
    
    private int categoryId;

    private String categoryName;

    private String categoryDescription;

    /**
     *
     * @param categoryId unique ID of the category
     * @param categoryName name of the category
     * @param categoryDescription a description of the category
     */
    public Category(int categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    /**
     * Gets categoryId
     * @return categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets categoryId
     * @param categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets categoryName
     * @return returns categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets categoryName
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets categoryDescription
     * @return returns categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Sets categoryDescription
     * @param categoryDescription
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}