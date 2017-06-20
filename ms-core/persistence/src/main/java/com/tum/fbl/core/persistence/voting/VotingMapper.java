package com.tum.fbl.core.persistence.voting;

import com.tum.fbl.core.persistence.voting.Voting;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class VotingMapper implements ResultSetMapper<Voting> {

    @Override
    public Voting map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Vote(
                r.getInt("votingId"),
                r.getInt("createdBy"),
                r.getDate("createdOn"),
                r.getDate("startDate"),
                r.getString("location"));
    }

}