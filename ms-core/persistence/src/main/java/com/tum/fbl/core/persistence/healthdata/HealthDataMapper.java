package com.tum.fbl.core.persistence.meal;

import com.tum.fbl.core.persistence.healthdata.HealthData;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class HealthDataMapper implements ResultSetMapper<HealthData> {

    @Override
    public HealthData map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new HealthData(
                r.getString("userId"),
                r.getString("deviceUserPassword"),
                r.getString("deviceUserId"),
                r.getFloat("currentHeartbeat"),
                r.getInt("heartbeatTimeRange"),
                r.getFloat("trackedCalorieToday"),
                r.getFloat("trackedCalorieTimeRange"),
                r.getInt("averageHeartbeatTimeRange"));
    }

}