package com.tum.fbl.core.persistence.rating;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(RatingMapper.class)
public interface RatingDao extends AutoCloseable{

    @SqlQuery("select * from rating where ratingId = :id")
    Rating findRatingById(@Bind("id") int ratingId);

    @SqlUpdate("Insert into rating (userId, mealId, ratingTimestamp, rating) value (:userId, :mealId, :ratingTimestamp, :rating)")
    void newRating(@Bind("userId") int userId,
                  @Bind("mealId") int mealId,
                   @Bind("ratingTimestamp") Date ratingTimestamp,
                  @Bind("rating") boolean rating);

    @SqlUpdate("delete from rating where ratingId = :id")
    void deleteRatingById(@Bind("id") int ratingId);

    //TODO: void update()

    public void close();
}
