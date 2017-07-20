package com.tum.fbl.core.persistence.user;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.Date;
import java.util.List;

/**
 * Created by patrickmelchner on 12.06.17.
 */

@RegisterMapper(UserMapper.class)
public interface UserDao extends AutoCloseable {

    @SqlQuery("select * from user where userId = :id")
    User findUserById(@Bind("id") int userId);

    @SqlQuery("select * from user where roleId = :roleId")
    List<User> getAllUser(@Bind("roleId") int roleId);

    @SqlQuery("select * from (select * from user where userId = :id) natural join mealRestaurant natural join meal")
    User findMealsById(@Bind("id") int userId);

    @SqlQuery("select u.* from (select * from UserMeal where mealId = :mealId) natural join user u")
    User findUserByMealId(@Bind("mealId") int mealId);

    @SqlQuery("select u.* from user u, order o where u.userId = o.userId and o.orderId = :orderId")
    User findUserByOrderId(@Bind("orderId") int orderId);

    @SqlQuery("select * from user where email = :email")
    User findUserByEmail(@Bind("email") String email);

    @SqlQuery("select u.* from (select * from UserCategory where categoryId = :categoryId) natural join user u ")
    List<User> findUsersByCategory(@Bind("categoryId") int categoryId);

    @GetGeneratedKeys
    @SqlUpdate("insert into user (userName, userPassword, email, birthday, height, weight, displayName, address, longitude, latitude, roleId) " +
            " values (:userName, :userPassword, :email, :birthday, :height, :weight, :displayName, :address, :longitude, :latitude, :roleId)")
    int newUser(@Bind("userName") String userName,
                 @Bind("userPassword") String userPassword,
                 @Bind("email") String email,
                 @Bind("birthday") Date birthday,
                 @Bind("height") int height,
                 @Bind("weight") int weight,
                 @Bind("displayName") String DisplayName,
                 @Bind("address") String address,
                 @Bind("longitude") float longitude,
                 @Bind("latitude") float latitude,
                 @Bind("roleId") int roleId);

    @SqlUpdate("Insert into userCategory (userId,categoryId) values (:userId, :categoryId); SELECT LAST_INSERT_ID() from userCategory")
    int newUserCategory(
            @Bind("userId") int userId,
            @Bind("categoryId") int categoryId
    );

    @SqlUpdate("delete from user where userId = :id")
    void deleteUser(@Bind("id") int userId);

    @SqlUpdate("update user set userName=:userName, userPassword=:userPassword, userEmail=:userEmail, weight=:weight, displayName=:displayName where userId=:userId")
    void updateUser(
            @Bind("userName") String userName,
            @Bind("userPassword") String userPassword,
            @Bind("userEmail") String userEmail,
            @Bind("weight") int weight,
            @Bind("displayName") String displayName
    );

    public void close();
}