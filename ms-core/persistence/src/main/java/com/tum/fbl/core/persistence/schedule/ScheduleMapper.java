package com.tum.fbl.core.persistence.schedule;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class ScheduleMapper implements ResultSetMapper<Schedule> {

    /**
     * Maps schedule data stored in db to Schedule.
     * @param index
     * @param r
     * @param ctx
     * @return Schedule
     * @throws SQLException
     */
    @Override
    public Schedule map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Schedule(
                r.getString("userId"),
                r.getInt("schedulesDayOfTheWeek"),
                r.getDate("schedulesOpeningTime"),
                r.getDate("schedulesClosingTime"));
    }

}