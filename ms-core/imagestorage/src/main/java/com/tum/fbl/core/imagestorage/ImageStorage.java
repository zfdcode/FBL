package com.tum.fbl.core.imagestorage;

import java.io.InputStream;

public interface ImageStorage {

    ImageStatus saveImage (InputStream uploadedInputStream) throws ImagePersistenceException;

}
