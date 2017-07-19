package com.tum.fbl.core.persistence.VotingOrderList;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marcel on 09.07.2017.
 * Documented bu jie on 02.07.2017.
 */
public class VotingOrderListMapper implements ResultSetMapper<VotingOrderList> {

    /**
     * Maps voting data stored in db to VotingOrderList.
     * @param index
     * @param r
     * @param ctx
     * @return
     * @throws SQLException
     */
    @Override
    public VotingOrderList map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new VotingOrderList(
                r.getInt("votingOrderListId"),
                r.getFloat("orderedAmount"),
                r.getDate("orderedAt"),
                r.getInt("votingPeriodId"),
                r.getInt("ingredientId"));
    }

}