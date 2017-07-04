package com.tum.fbl.core.service.exceptions;

import javax.ws.rs.WebApplicationException;

/**
 * Created by patrickmelchner on 02.07.17.
 */
public class ImageException extends WebApplicationException {

    public ImageException() {
        super();
    }


    public ImageException(Throwable e) {
        super(e);
    }


    public ImageException(String message) {
        super(message);
    }

}
