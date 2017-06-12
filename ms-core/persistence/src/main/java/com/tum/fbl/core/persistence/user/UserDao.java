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

    @SqlQuery("select * from user where id = :id")
    User findNameById(@Bind("id") String id);

    @SqlQuery("select * from user where email = :email")
    User findNameByEmail(@Bind("email") String email);

    @SqlUpdate("insert into user (name, email, password) values (:name, :email, :password)")
    void newUser(@Bind("name") String name, @Bind("email") String email, @Bind("password") String password);
}
