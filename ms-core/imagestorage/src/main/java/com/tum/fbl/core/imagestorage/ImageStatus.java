package com.tum.fbl.core.imagestorage;

import java.util.Optional;

/**
 * Created by patrickmelchner on 26.05.17.
 */
public class ImageStatus {

    public final String path;

    public ImageStatus (String path) {
        this.path = path;
    }

    public Optional<String> getId () {
        return Optional.of(this.path);
    }
}
