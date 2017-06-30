package com.tum.fbl.core.service.auth;

import de.qaware.heimdall.Password;
import de.qaware.heimdall.PasswordException;
import de.qaware.heimdall.PasswordFactory;
import de.qaware.heimdall.SecureCharArray;

/**
 * Created by patrickmelchner on 30.06.17.
 */
public class PBKDF2WithHmacSHA1Hasher implements PasswordHasher {

    public String hashPassword (String secret) throws PasswordException {
        Password password = PasswordFactory.create();

        try(SecureCharArray cleartext = new SecureCharArray(secret.toCharArray())) {
            return password.hash(cleartext);
        }
    }

    public boolean checkPassword (String hash, String secret) throws PasswordException {
        Password password = PasswordFactory.create();

        try(SecureCharArray cleartext = new SecureCharArray(secret.toCharArray())) {
            return password.verify(cleartext, hash);
        }
    }
}
