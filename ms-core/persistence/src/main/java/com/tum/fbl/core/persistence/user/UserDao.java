package com.tum.fbl.core.persistence.user;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by patrickmelchner on 12.06.17.
 */

@RegisterMapper(UserMapper.class)
public interface UserDao extends AutoCloseable {

    @SqlQuery("select * from user where userId = :id")
    User findUserById(@Bind("id") int userId);

    @SqlQuery("select * from meals join user on mealRestaurant join mealRestaurant on user where userId = :id")
    User findUserById(@Bind("id") int userId);

    @SqlQuery("select * from user where email = :email")
    User findUserByEmail(@Bind("email") String email);

    @SqlUpdate("insert into user (userName, userPassword, email, birthday, height, weight, DisplayName, restaurantAddress, role) " +
            "values (:userName, :userPassword, :email, :birthday, :height, :weight, :DisplayName, :restaurantAddress, :role)")
    void newUser(@Bind("userName") String userName,
                 @Bind("userPassword") String userPassword,
                 @Bind("email") String email,
                 @Bind("birthday") Date birthday,
                 @Bind("height") int height,
                 @Bind("weight") int weight,
                 @Bind("DisplayName") String DisplayName,
                 @Bind("restaurantAddress") String restaurantAddress,
                 @Bind("role") String role);

    @SqlQuery("delete from user where userId = :id")
    void deleteUser(@Bind("id") int userId);
}