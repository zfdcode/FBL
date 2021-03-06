package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.User;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.user.UserDao;
import com.tum.fbl.core.service.auth.PBKDF2WithHmacSHA1Hasher;
import com.tum.fbl.core.service.auth.PasswordHasher;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
import de.qaware.heimdall.PasswordException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfngd on 2017/6/15.
 * Documented by jie on 03.07.2017.
 */

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "User API", description = "Provides the user information.")
public class UserResource {

    private final int role = 0;

    private final ConnectionFactory connectionFactory;

    private final PasswordHasher passwordHasher;

    /**
     * Connects the factory for user resource.
     *
     * @param connectionFactory the connection factory
     */
    public UserResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;

        this.passwordHasher = new PBKDF2WithHmacSHA1Hasher();
    }

    @GET
    @Path("/all")
    @ApiOperation(value = "Get basic user information")
    public List<User> getUsers() {

        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<User> users = new ArrayList<>();

            List<com.tum.fbl.core.persistence.user.User> userList = userDao.getAllUser(this.role);
            if (userList != null) {
                for (com.tum.fbl.core.persistence.user.User user : userList) {
                    users.add(new User(user));
                }
            }
            return users;
        }
    }

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return User
     */
    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic user information")
    public User getUser(@PathParam("userId") int userId) {

        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User user = userDao.findUserById(userId);

            if (user != null) {
                return new User(user);
            } else {
                return null;
            }
        }
    }

    /**
     * Deletes user.
     *
     * @param userId the user id
     */
    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Deletes a user")
    public void deleteUser(@PathParam("userId") int userId) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            userDao.deleteUser(userId);
        }
    }

    /**
     * Adds user.
     *
     * @param user the user
     */
    @POST
    @ApiOperation(value = "Add a new user to the store")
    public int addUser(User user) throws IllegalArgumentExpection {

        if (user != null) {

            try {
                String hashedPasswd = this.passwordHasher.hashPassword(user.getUserPassword());

                try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
                    return userDao.newUser(
                            user.getUserName(),
                            hashedPasswd,
                            user.getEmail(),
                            user.getBirthday(),
                            user.getHeight(),
                            user.getWeight(),
                            user.getDisplayName(),
                            "",
                            0,
                            0,
                            this.role
                    );
                }
            } catch (PasswordException e) {
                throw new IllegalArgumentExpection("Password is invalid");
            }
        } else {
            throw new IllegalArgumentExpection();
        }

    }

    @GET
    @Path("/email/{email}")
    @ApiOperation(value = "Get basic user information")
    public User getUserByEmail(@PathParam("email") String email) {

        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User user = userDao.findUserByEmail(email);

            if (user != null) {
                return new User(user);
            } else {
                return null;
            }
        }
    }


    /**
     * Updates user.
     *
     * @param user the user
     */
    @PUT
    @ApiOperation(value = "Update an existing user")
    public void updateUser(User user) throws IllegalArgumentExpection {

        if (user != null) {

            try {
                String hashedPasswd = this.passwordHasher.hashPassword(user.getUserPassword());

                try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
                    userDao.updateUser(
                            user.getUserId(),
                            user.getUserName(),
                            hashedPasswd,
                            user.getEmail(),
                            user.getWeight(),
                            user.getDisplayName()
                    );
                }
            } catch (PasswordException e) {
                throw new IllegalArgumentExpection("Password is invalid");
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

    /**
     * Gets user by special need.
     *
     * @param categoryId the special need id
     * @return List<User> the list of users
     */
    @GET
    @Path("/category/{categoryId}")
    @ApiOperation(value = "Get users by special need")
    public List<User> getUsersByCategory(@PathParam("categoryId") int categoryId) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<User> users = new ArrayList<>();

            List<com.tum.fbl.core.persistence.user.User> userList = userDao.findUsersByCategory(categoryId);
            if (userList != null) {
                for (com.tum.fbl.core.persistence.user.User user : userList) {
                    users.add(new User(user));
                }
            }
            return users;
        }
    }

}
