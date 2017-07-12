package com.tum.fbl.core.service.exceptions;

import javax.ws.rs.WebApplicationException;

/**
 * Created by patrickmelchner on 12.07.17.
 */
public class IllegalArgumentExpection extends WebApplicationException {

    public IllegalArgumentExpection() {
        super();
    }


    public IllegalArgumentExpection(Throwable e) {
        super(e);
    }


    public IllegalArgumentExpection(String message) {
        super(message);
    }

}
