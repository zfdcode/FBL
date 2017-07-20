package com.tum.fbl.core.persistence.vote;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper(VoteMapper.class)
public interface VoteDao extends AutoCloseable {

    @SqlQuery("select * from vote where votingIngItemId = :votingIngItemId")
    List<Vote> findVotesByIngItemId(@Bind("votingIngItemId") int votingIngItemId);

    @SqlQuery("select * from vote where voteId = :id")
    Vote findVoteById(@Bind("id") int voteId);

    @GetGeneratedKeys
    @SqlUpdate("Insert into vote (votingIngItemId, userId, type) value (:votingIngItemId, :userId, :type)")
    int newVote(@Bind("votingIngItemId") int votingIngItemId,
                 @Bind("userId") int userId,
                 @Bind("type") String type);

    @SqlUpdate("delete from vote where voteId = :id")
    void deleteVoteById(@Bind("id") int voteId);

    @SqlUpdate("delete from vote where votingIngItemId = :votingIngItemId AND userId = :userId")
    void deleteVoteByIng(@Bind("votingIngItemId") int votingIngItemId,
                         @Bind("userId") int userId);

    public void close();
}
