package com.tum.fbl.core.persistence.healthdata;

import com.tum.fbl.core.persistence.healthdata.HealthData;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class HealthDataMapper implements ResultSetMapper<HealthData> {

    /**
     * Maps health data stored in db to HealthData.
     * @param index
     * @param r
     * @param ctx
     * @return HealthData
     * @throws SQLException
     */
    @Override
    public HealthData map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new HealthData(
                r.getInt("userId"),
                r.getString("deviceUserPassword"),
                r.getInt("deviceUserId"),
                r.getFloat("burnedCalories"),
                r.getFloat("trackedCaloriesRange"),
                r.getFloat("calorieGoal"));
    }

}