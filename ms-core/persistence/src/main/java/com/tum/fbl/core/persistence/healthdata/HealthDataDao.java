package com.tum.fbl.core.persistence.healthdata;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(HealthDataMapper.class)
public interface HealthDataDao extends AutoCloseable {

    @SqlQuery("select * from healthTrackerData where userId = :id")
    HealthData findHealthDataById(@Bind("id") int userId);

    @SqlUpdate("Insert into healthTrackerData (userId, deviceUserPassword, deviceUserId, currentHeartbeat, heartbeatTimeRange, trackedCalorieToday, trackedCalorieTimeRange, averageHeartbeatTimeRange) " +
            "values (:userId, :deviceUserPassword, :deviceUserId, :currentHeartbeat, :heartbeatTimeRange, :trackedCalorieToday, :trackedCalorieTimeRange, :averageHeartbeatTimeRange)")
    void newHealthData(
            @Bind("userId") int userId,
            @Bind("deviceUserPassword") String deviceUserPassword,
            @Bind("deviceUserId") int deviceUserId,
            @Bind("currentHeartbeat") float currentHeartbeat,
            @Bind("heartbeatTimeRange") int heartbeatTimeRange,
            @Bind("trackedCalorieToday") float trackedCalorieToday,
            @Bind("trackedCalorieTimeRange") float trackedCalorieTimeRange,
            @Bind("averageHeartbeatTimeRange") int averageHeartbeatTimeRange);

    @SqlQuery("delte from healthTrackerData where userId = :id")
    void deleteHealthData(@Bind("id") int userId);

    //TODO: updateHealtData

    public void close();
}
