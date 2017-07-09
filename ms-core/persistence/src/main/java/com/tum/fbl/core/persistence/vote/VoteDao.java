package com.tum.fbl.core.persistence.vote;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper(VoteMapper.class)
public interface VoteDao extends AutoCloseable {

    @SqlQuery("select * from vote where voteId = :id")
    Vote findVoteById(@Bind("id") int voteId);

    @SqlUpdate("Insert into vote (votingIngItemId, userId, type) value (:votingIngItemId, :userId, :type)")
    void newVote(@Bind("votingIngItemId") int votingIngItemId,
                 @Bind("userId") int userId,
                 @Bind("type") String like);

    @SqlUpdate("delete from vote where voteId = :id")
    void deleteVoteById(@Bind("id") int voteId);

    //TODO: void update()

    public void close();
}
