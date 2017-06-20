package com.tum.fbl.core.persistence.tag;

import com.tum.fbl.core.persistence.tag.Tag;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class TagMapper implements ResultSetMapper<Tag> {

    @Override
    public Tag map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Tag(
                r.getInt("tagId"),
                r.getString("tagName"));
    }

}