package com.tum.fbl.core.persistence.meal;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(MealMapper.class)
public interface HealthDataDao extends AutoCloseable{

    @SqlQuery("select * from healthTrackerData where userId = :id")
    Meal findMealById(@Bind("id") String id);

    @SqlUpdate("Insert into healthTrackerData (userId, deviceUserPassword, deviceUserId, currentHeartbeat, heartbeatTimeRange, trackedCalorieToday, trackedCalorieTimeRange, averageHeartbeatTimeRange) values (:userId, :deviceUserPassword, :deviceUserId, :currentHeartbeat, :heartbeatTimeRange, :trackedCalorieToday, :trackedCalorieTimeRange, :averageHeartbeatTimeRange)")
    void newMeal(
            @Bind("userId") String userId,
            @Bind("deviceUserPassword") String deviceUserPassword,
            @Bind("deviceUserId") String deviceUserId,
            @Bind("currentHeartbeat") int currentHeartbeat,
            @Bind("heartbeatTimeRange") int heartbeatTimeRange,
            @Bind("trackedCalorieToday") float trackedCalorieToday,
            @Bind("trackedCalorieTimeRange") float trackedCalorieTimeRange,
            @Bind("averageHeartbeatTimeRange") int averageHeartbeatTimeRange);

}
