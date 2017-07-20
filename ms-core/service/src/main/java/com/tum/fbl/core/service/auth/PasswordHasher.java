package com.tum.fbl.core.service.auth;

import de.qaware.heimdall.PasswordException;

/**
 * Created by patrickmelchner on 30.06.17.
 */
public interface PasswordHasher {

    String hashPassword(String password) throws PasswordException;

    boolean checkPassword (String db, String passwd) throws PasswordException;
}
