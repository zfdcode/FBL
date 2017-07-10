package com.tum.fbl.core.service.auth;


import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.user.UserDao;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;


/**
 * Created by patrickmelchner on 23.05.17.
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, User> {

    private ConnectionFactory connectionFactory;

    private PasswordHasher passwordHasher;

    public BasicAuthenticator (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;

        this.passwordHasher = new PBKDF2WithHmacSHA1Hasher();
    }

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {

        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User user = userDao.findUserByEmail(credentials.getUsername());
            if (user == null) {
                return Optional.empty();
            } else {
                try {
                    if (this.passwordHasher.checkPassword(user.getUserPassword(), credentials.getPassword())) {
                        return Optional.of(new User(credentials.getUsername(), user.getUserPassword()));
                    } else {
                        return Optional.empty();
                    }
                } catch (Exception e) {
                    return Optional.empty();
                }
            }
        }
    }

}
