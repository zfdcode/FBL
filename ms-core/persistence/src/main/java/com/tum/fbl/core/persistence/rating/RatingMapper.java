package com.tum.fbl.core.persistence.rating;

import com.tum.fbl.core.persistence.rating.Rating;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by malte on 13.06.2017.
 */
public class RatingMapper implements ResultSetMapper<Rating> {

    @Override
    public Rating map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        /*
        return new Rating(
                r.getInt("ratingId"),
                r.getInt("userId"),
                r.getInt("mealId"),
                r.getFloat("rating"));
                */
        return null;
    }

}