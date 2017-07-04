package com.tum.fbl.core.imagestorage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tum.fbl.core.config.ImageUploadConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * Created by patrickmelchner on 26.05.17.
 */
public class ImageStorageImpl implements ImageStorage{

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageStorageImpl.class);

    private final ImageUploadConfiguration config;

    private Cloudinary cloudinary;

    public ImageStorageImpl (ImageUploadConfiguration config) {
        this.config = config;

        this.buildConfig();
    }

    private void buildConfig () {
         this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", this.config.getName(),
                "api_key", this.config.getKey(),
                "api_secret", this.config.getSecret()));
    }

    public ImageStatus saveImage (InputStream uploadedInputStream, String name) throws ImagePersistenceException {

        String path = this.config.getPath() + name;


        try {
            this.saveFile(uploadedInputStream, path);

            File f = new File(path);

            Map uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
            LOGGER.info("Uploaded File: " + uploadResult.get("secure_url").toString());

            this.deleteFile(path);

            return new ImageStatus(uploadResult.get("secure_url").toString());

        } catch (IOException e) {
            LOGGER.error("Failed to upload file: " + e.getMessage());
            throw new ImagePersistenceException();
        }

    }

    public void saveFile (InputStream is, String path) throws IOException {

            OutputStream os = new FileOutputStream(path);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = is.read(buffer)) !=-1){

                os.write(buffer, 0, bytesRead);
            }

            is.close();
            os.flush();
            os.close();

        LOGGER.info("Saved File: " + path);

    }

    public void deleteFile (String path) throws IOException {

        File f = new File(path);
        if (f.delete()) {
            LOGGER.info("Deleteted File: " + path);
        } else {
            LOGGER.error("Could NOT be deleteted: " + path);
        }
    }

}
