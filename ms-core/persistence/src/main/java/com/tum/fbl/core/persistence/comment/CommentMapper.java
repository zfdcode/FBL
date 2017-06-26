package com.tum.fbl.core.persistence.comment;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Malte on 26.06.2017.
 */
public class CommentMapper implements ResultSetMapper<Comment> {

    @Override
    public Comment map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Comment(
                r.getInt("commentId"),
                r.getString("comment"));
    }
}
