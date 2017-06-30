package com.tum.fbl.core.persistence.vote;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class VoteMapper implements ResultSetMapper<Vote> {

    @Override
    public Vote map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Vote(
                r.getInt("voteId"),
                r.getInt("ingredientId"),
                r.getInt("votingId"),
                r.getInt("userId"),
                r.getString("like"));
    }

}