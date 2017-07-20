package com.tum.fbl.core.persistence.healthdata;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
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

    @GetGeneratedKeys
    @SqlUpdate("Insert into healthTrackerData (userId, deviceUserPassword, deviceUserId, burnedCalories, trackedCaloriesRange, calorieGoal) " +
            "values (:userId, :deviceUserPassword, :deviceUserId, :burnedCalories, :trackedCaloriesRange, :calorieGoal) ")
    int newHealthData(
            @Bind("userId") int userId,
            @Bind("deviceUserPassword") String deviceUserPassword,
            @Bind("deviceUserId") int deviceUserId,
            @Bind("burnedCalories") float burnedCalories,
            @Bind("trackedCaloriesRange") float trackedCalorieTimeRange,
            @Bind("calorieGoal") float calorieGoal);

    @SqlUpdate("delete from healthTrackerData where userId = :id")
    void deleteHealthData(@Bind("id") int userId);

    @SqlUpdate("update healthTrackerData set deviceUserPassword = :deviceUserPassword, deviceUserId = :deviceUserId, burnedCalorie = :burnedCalories, trackedCaloriesRange = :trackedCaloriesRange, calorieGoal= :calorieGoal where userId = :id")
    void updateHealthData(@Bind("userId") int userId,
                          @Bind("deviceUserPassword") String deviceUserPassword,
                          @Bind("deviceUserId") int deviceUserId,
                          @Bind("burnedCalories") float burnedCalories,
                          @Bind("trackedCaloriesRange") float trackedCalorieTimeRange,
                          @Bind("calorieGoal") float calorieGoal);

    void close();
}
