package com.tum.fbl.core.bdo;

/**
 * Documented by jie on 25.06.2017.
 */

public class IngredientTag {
    private int tagId;

    private String tagName;

    /**
     * Constructs IngredientTag that specifies the features of the ingredient.
     * @param tagId unique ID of the tag
     * @param tagName name of the tag for users to recognize the feature of the ingredient
     */
    public IngredientTag(int tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    /**
     * Gets TagId.
     * @return tagId unique ID of the tag
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * Sets TagId.
     * @param tagId unique ID of the tag
     */
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /**
     * Gets TagName.
     * @return tagName name of the tag for users to recognize the feature of the ingredient
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Sets TagName.
     * @param tagName name of the tag for users to recognize the feature of the ingredient
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}