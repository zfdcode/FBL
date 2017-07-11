package com.tum.fbl.core.persistence.user;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by patrickmelchner on 12.06.17.
 */

@RegisterMapper(UserMapper.class)
public interface UserDao extends AutoCloseable {

    @SqlQuery("select * from user where userId = :id")
    User findUserById(@Bind("id") int userId);

    @SqlQuery("select * from user")
    List<User> getAllUser();

    @SqlQuery("select * from (select * from user where userId = :id) natural join mealRestaurant natural join meal")
    User findMealsById(@Bind("id") int userId);

    @SqlQuery("select * from user where email = :email")
    User findUserByEmail(@Bind("email") String email);

    @SqlUpdate("insert into user (userName, userPassword, email, birthday, height, weight, DisplayName, address, longtitude, latitude, roleId)  values (:userName, :userPassword, :email, :birthday, :height, :weight, :DisplayName, :address, :longtitude, :latitude, :roleId)")
    int newUser(@Bind("userName") String userName,
                 @Bind("userPassword") String userPassword,
                 @Bind("email") String email,
                 @Bind("birthday") Date birthday,
                 @Bind("height") int height,
                 @Bind("weight") int weight,
                 @Bind("DisplayName") String DisplayName,
                 @Bind("address") String address,
                 @Bind("longtitude") float longtitude,
                 @Bind("latitude") float latitude,
                 @Bind("roleId") int roleId);

    @SqlUpdate("delete from user where userId = :id")
    void deleteUser(@Bind("id") int userId);

    //TODO: updateUser

    public void close();
}