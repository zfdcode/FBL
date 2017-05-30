package com.tum.fbl.core.imagestorage;

import java.io.InputStream;

/**
 * Created by patrickmelchner on 26.05.17.
 */
public class ImageStorageImpl implements ImageStorage{

    public ImageStatus saveImage (InputStream uploadedInputStream) throws ImagePersistenceException {

        return new ImageStatus("function not implemented");
    }

}
