package com.tum.fbl.core.persistence.VotingPeriod;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class VotingPeriodMapper implements ResultSetMapper<VotingPeriod> {

    /**
     * Maps voting data stored in db to VotingOrderList.
     * @param index
     * @param r
     * @param ctx
     * @return
     * @throws SQLException
     */
    @Override
    public VotingPeriod map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new VotingPeriod(
                r.getInt("VotingPeriodId"),
                r.getDate("startTime"),
                r.getDate("endTime"),
                r.getBoolean("isFinished"),
                r.getInt("calendarWeek"));
    }

}