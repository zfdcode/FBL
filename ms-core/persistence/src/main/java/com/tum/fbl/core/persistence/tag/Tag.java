package com.tum.fbl.core.persistence.tag;

public class Tag {

    private int tagId;

    private String tagName;

    private String tagDescription;

    /**
     *
     * @param tagId the tag's unique ID
     * @param tagName the tag's name
     * @param tagDescription a description of the tag
     */
    public Tag(int tagId, String tagName, String tagDescription) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

    /**
     * gets the tagId
     * @return tagId
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * sets the tagId
     * @param tagId
     */
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /**
     * gets the tagName
     * @return tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * sets the tagName
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * gets the tagDescription
     * @return tagDescription
     */
    public String getTagDescription() {
        return tagDescription;
    }

    /**
     * sets the tagDescription
     * @param tagDescription
     */
    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

}
