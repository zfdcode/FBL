package com.tum.fbl.core.persistence.rating;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(RatingMapper.class)
public interface RatingDao extends AutoCloseable{

    @SqlQuery("select * from rating where ratingId = :id")
    Category findRatingById(@Bind("id") int ratingId);

    @SqlUpdate("Insert into rating (userId, mealId, rating) value (:userId, :mealId, :rating)")
    void newRating(@Bind("userId") int userId,
                  @Bind("mealId") int mealId,
                  @Bind("rating") float rating);

    @SqlUpdate("delete from rating where ratingId = :id")
    void deleteRatingById(@Bind("id") int ratingId);
}
