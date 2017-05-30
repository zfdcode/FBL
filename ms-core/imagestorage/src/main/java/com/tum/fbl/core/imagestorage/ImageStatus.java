package com.tum.fbl.core.imagestorage;

import java.util.Optional;

/**
 * Created by patrickmelchner on 26.05.17.
 */
public class ImageStatus {

    public String id;

    public ImageStatus (String id) {
        this.id = id;
    }

    public Optional<String> getId () {
        return Optional.of(id);
    }
}
