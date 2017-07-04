package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.User;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.user.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    private final ConnectionFactory connectionFactory;

    /**
     * Connects the factory for user resource.
     * @param connectionFactory the connection factory
     */
    public UserResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets user.
     * @param userId the user id
     * @return User
     */
    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic user information")
    public User getUser(@PathParam("userId") int userId) {

        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            com.tum.fbl.core.persistence.user.User user = userDao.findUserById(userId);

            return new User(
                    user.getUserId(),
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getEmail(),
                    user.getBirthday(),
                    user.getHeight(),
                    user.getWeight()
            );
        }
    }

    /**
     * Deletes user.
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
     * @param user the user
     */
    @POST
    @ApiOperation(value = "Add a new user to the store")
    public void addUser(User user) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            userDao.newUser(
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getEmail(),
                    user.getBirthday(),
                    user.getHeight(),
                    user.getWeight(),
                    user.getDisplayName(),
                    user.getRestaurantAddress(),
                    user.getRole()
            );
        }
    }

    /**
     * Updates user.
     * @param user the user
     */
    @PUT
    @ApiOperation(value = "Update an existing user")
    public void updateUser(User user) {
        try (UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            //TODO: userdao.updateUser
            userDao.newUser(
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getEmail(),
                    user.getBirthday(),
                    user.getHeight(),
                    user.getWeight(),
                    user.getDisplayName(),
                    user.getRestaurantAddress(),
                    user.getRole()
            );
        }
    }

    /**
     * Gets user by special need.
     * @param specialNeedId the special need id
     * @return List<User> the list of users
     */
    @GET
    @Path("/sn/{specialNeedId}")
    @ApiOperation(value = "Get users by special need")
    public List<User> getUsersBySpecialNeed(@PathParam("specialNeedId") int specialNeedId) {
        return null;
    }

    /**
     * Gets users by ingredient
     * @param ingredientId the ingredient id
     * @return List<User> the list of users
     */
    @GET
    @Path("/ingredient/{ingredientId}")
    @ApiOperation(value = "Get users by selected ingredient")
    public List<User> getUsersByIngredient(@PathParam("ingredientId") int ingredientId) {
        return null;
    }

    /**
     * Gets users by meal
     * @param mealId the meal id
     * @return List<User> the list of users
     */
    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get users by selected meal")
    public List<User> getUsersByMeal(@PathParam("mealId") int mealId) {
        return null;
    }
}
