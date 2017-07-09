package com.tum.fbl.core.persistence.VotingIngItem;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class VotingIngItemMapper implements ResultSetMapper<VotingIngItem> {

    /**
     * Maps voting data stored in db to VotingIngItem.
     * @param index
     * @param r
     * @param ctx
     * @return VotingOrderList
     * @throws SQLException
     */
    @Override
    public VotingIngItem map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new VotingIngItem(
                r.getInt("votingIngItemId"),
                r.getInt("votingPeriodId"),
                r.getBoolean("isIgnored"),
                r.getInt("ingredientId"));
    }

}