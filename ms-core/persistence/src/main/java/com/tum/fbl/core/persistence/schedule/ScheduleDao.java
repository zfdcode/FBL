package com.tum.fbl.core.persistence.schedule;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.Date;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(ScheduleMapper.class)
public interface ScheduleDao extends AutoCloseable{

    @SqlQuery("select * from schedule where userId = :id")
    Schedule findScheduleById(@Bind("id") int userId);

    @GetGeneratedKeys
    @SqlUpdate("Insert into schedule (schedulesDayOfTheWeek, schedulesOpeningTime, schedulesClosingTime) values (:schedulesDayOfTheWeek, :schedulesOpeningTime, :schedulesClosingTime)")
    int newSchedule(@Bind("schedulesDayOfTheWeek") int schedulesDayOfTheWeek,
                     @Bind("schedulesOpeningTime") Date schedulesOpeningTime,
                     @Bind("schedulesClosingTime") Date schedulesClosingTime);

    @SqlUpdate("delete from schedule where userId = :id")
    void deleteScheduleById(@Bind("id") int userId);

    public void close();
}
