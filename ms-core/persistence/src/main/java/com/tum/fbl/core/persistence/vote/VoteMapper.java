package com.tum.fbl.core.persistence.vote;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 * Documented bu jie on 02.07.2017.
 */
public class VoteMapper implements ResultSetMapper<Vote> {

    /**
     * Maps vote data stored in db to Vote.
     * @param index
     * @param r
     * @param ctx
     * @return Vote
     * @throws SQLException
     */
    @Override
    public Vote map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Vote(
                r.getInt("voteId"),
                r.getInt("votingIngItemId"),
                r.getInt("userId"),
                r.getString("type"));
    }

}