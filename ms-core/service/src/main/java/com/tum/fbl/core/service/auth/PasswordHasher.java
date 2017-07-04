package com.tum.fbl.core.service.auth;

/**
 * Created by patrickmelchner on 30.06.17.
 */
public interface PasswordHasher {

    String hashPassword(String password) throws Exception;

    boolean checkPassword (String db, String passwd) throws Exception;
}
