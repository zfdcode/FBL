package com.tum.fbl.core.persistence.wearable;

import com.tum.fbl.core.persistence.wearable.Wearable;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class WearableMapper implements ResultSetMapper<Wearable> {

    /**
     * Maps wearable device data stored in db to Wearable.
     * @param index
     * @param r
     * @param ctx
     * @return Wearable
     * @throws SQLException
     */
    @Override
    public Wearable map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Wearable(
                r.getInt("deviceId"),
                r.getInt("diviceType"),
                r.getDate("connectionTime"),
                r.getDate("exitTime"),
                r.getInt("deviceUserId"),
                r.getString("deviceUserPassword"));
    }

}