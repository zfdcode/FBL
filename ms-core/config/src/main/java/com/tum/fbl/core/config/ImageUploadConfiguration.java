package com.tum.fbl.core.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by patrickmelchner on 02.07.17.
 */
public class ImageUploadConfiguration {

    @JsonProperty("name")
    private String name;

    @JsonProperty("key")
    private String key;


    @JsonProperty("secret")
    private String secret;

    @JsonProperty("path")
    private String path;


    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }

    public String getPath() {return path;}
}
