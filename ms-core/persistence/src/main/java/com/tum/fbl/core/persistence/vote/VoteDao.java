package com.tum.fbl.core.persistence.vote;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper(VoteMapper.class)
public interface VoteDao extends AutoCloseable{

    @SqlQuery("select * from vote where voteId = :id")
    Vote findVoteById(@Bind("id") int voteId);

    @SqlUpdate("Insert into vote (ingredientId, votingId, userId, like) value (:ingredientId, :votingId, :userId, :like)")
    void newVote(@Bind("ingredientId") int ingredientId,
                 @Bind("votingId") int votingId,
                 @Bind("userId") int userId,
                 @Bind("like") String like);

    @SqlUpdate("delete from vote where voteId = :id")
    void deleteVoteById(@Bind("id") int voteId);
}
