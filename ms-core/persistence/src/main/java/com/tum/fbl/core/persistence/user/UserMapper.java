package com.tum.fbl.core.persistence.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by patrickmelchner on 12.06.17.
 * Documented bu jie on 02.07.2017.
 */
public class UserMapper implements ResultSetMapper<User> {

    /**
     * Maps user data stored in db to User.
     * @param index
     * @param r
     * @param ctx
     * @return User
     * @throws SQLException
     */
    @Override
    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new User(r.getInt("userId"),
                r.getString("userName"),
                r.getString("userPassword"),
                r.getString("email"),
                r.getDate("birthday"),
                r.getInt("height"),
                r.getInt("weight"),
                r.getString("DisplayName"),
                r.getString("restaurantAddress"),
                r.getFloat("longitude"),
                r.getFloat("latitude"),
                r.getString("role"));
    }
}
