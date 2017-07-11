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
    /**
     * gets entry from the HealthData table in the database for a specified user
     * @param userId the unique ID of the user
     * @return HealthData object
     */
    @SqlQuery("select * from healthTrackerData where userId = :id")
    HealthData findHealthDataById(@Bind("id") int userId);

    /**
     * Inserts a new entry into the HealthData table in the database
     * @param userId the unique ID of the user
     * @param deviceUserPassword
     * @param deviceUserId
     * @param burnedCalories
     * @param trackedCalorieTimeRange
     * @param calorieGoal
     */
    @SqlUpdate("Insert into healthTrackerData (userId, deviceUserPassword, deviceUserId, burnedCalorie, trackedCalorieTimeRange, calorieGoal) " +
            "values (:userId, :deviceUserPassword, :deviceUserId, :burnedCalories, :trackedCalorieTimeRange, :calorieGoal) ; SELECT LAST_INSERT_ID() from healthTrackerData")
    int newHealthData(
            @Bind("userId") int userId,
            @Bind("deviceUserPassword") String deviceUserPassword,
            @Bind("deviceUserId") int deviceUserId,
            @Bind("burnedCalories") float burnedCalories,
            @Bind("trackedCalorieTimeRange") float trackedCalorieTimeRange,
            @Bind("calorieGoal") float calorieGoal);

    /**
     * deletes an entry from the HealthData table in the database
     * @param userId the unique id of the user who the entry will be deleted for
     */
    @SqlUpdate("delete from healthTrackerData where userId = :id")
    void deleteHealthData(@Bind("id") int userId);

    /**
     * updates an existing entry in the HealthData table in the database
     * @param userId
     * @param deviceUserPassword
     * @param deviceUserId
     * @param burnedCalories
     * @param trackedCalorieTimeRange
     * @param calorieGoal
     */
    @SqlUpdate("update healthTrackerData set deviceUserPassword = :deviceUserPassword, deviceUserId = :deviceUserId, burnedCalorie = :burnedCalorie, trackedCalorieTimeRange = :trackedCalorieTimeRange, calorieGoal= :calorieGoal where userId = :id")
    void updateHealthData(@Bind("userId") int userId,
                          @Bind("deviceUserPassword") String deviceUserPassword,
                          @Bind("deviceUserId") int deviceUserId,
                          @Bind("burnedCalories") float burnedCalories,
                          @Bind("trackedCalorieTimeRange") float trackedCalorieTimeRange,
                          @Bind("calorieGoal") float calorieGoal);

    public void close();
}
