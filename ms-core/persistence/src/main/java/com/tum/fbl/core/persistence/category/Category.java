package com.tum.fbl.core.persistence.category;

public class Category {
    
    private int categoryId;

    private String categoryName;

    private String categoryDescription;

    public Category(int categoryId, String categoryName, String catecoryDecription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = catecoryDecription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatecoryDecription() {
        return categoryDescription;
    }

    public void setCatecoryDecription(String catecoryDecription) {
        this.categoryDescription = catecoryDecription;
    }
}