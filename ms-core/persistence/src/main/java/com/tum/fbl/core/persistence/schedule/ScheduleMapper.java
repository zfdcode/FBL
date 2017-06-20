package com.tum.fbl.core.persistence.schedule;

import com.tum.fbl.core.persistence.schedule.Schedule;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class ScheduleMapper implements ResultSetMapper<Schedule> {

    @Override
    public Schedule map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Schedule(
                r.getInt("userId"),
                r.getInt("schedulesDayOfTheWeek"),
                r.getDate("schedulesOpeningTime"),
                r.getDate("schedulesClosingTime"));
    }

}