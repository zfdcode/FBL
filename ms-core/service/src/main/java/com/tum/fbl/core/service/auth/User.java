package com.tum.fbl.core.service.auth;

import com.google.common.base.Preconditions;

import java.security.Principal;

/**
 * Created by patrickmelchner on 23.05.17.
 */
public class User implements Principal {

    /**
     * User name
     */
    private final String name;

    /**
     * User password
     */
    private String password;

    public User(String name, String password) {
        this.name = Preconditions.checkNotNull(name);
        this.password = Preconditions.checkNotNull(password);
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
}
