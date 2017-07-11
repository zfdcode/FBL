package com.tum.fbl.core.bdo;

/**
 * Created by zfngd on 2017/6/4.
 */
public class Category {

    private int categoryId;

    private String categoryName;

    private String categoryDescription;

    public Category(int categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Category(com.tum.fbl.core.persistence.category.Category category){
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.categoryDescription = category.getCategoryDescription();
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

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
