package com.tum.fbl.core.persistence.rating;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(RatingMapper.class)
public interface RatingDao extends AutoCloseable{

    @SqlQuery("select * from rating where ratingId = :id")
    Rating findRatingById(@Bind("id") int ratingId);

    @SqlQuery("select * from rating where userId = :userId")
    List<Rating> findRatingsByUserId(@Bind("userId") int userId);

    @SqlQuery("select * from rating where mealId= :mealId")
    List<Rating> findRatingsByMealId(@Bind("mealId") int mealId);

    @SqlUpdate("Insert into rating (userId, mealId, ratingTimestamp, rating) value (:userId, :mealId, :ratingTimestamp, :rating) ; SELECT LAST_INSERT_ID() from rating")
    int newRating(@Bind("userId") int userId,
                  @Bind("mealId") int mealId,
                  @Bind("ratingTimestamp") Date ratingTimestamp,
                  @Bind("rating") float rating);

    @SqlUpdate("delete from rating where ratingId = :id")
    void deleteRatingById(@Bind("id") int ratingId);

    @SqlUpdate("update rating set ratingTimestamp= :timestamp, rating= :rating  where ratingId = :id")
    void updateRating(
            @Bind("id") int id,
            @Bind("rating") float rating,
            @Bind("timestamp") Date timestamp
    );

    void close();
}
