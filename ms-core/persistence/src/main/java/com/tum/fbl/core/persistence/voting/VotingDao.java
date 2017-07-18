package com.tum.fbl.core.persistence.voting;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.Date;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper( VotingMapper.class)
public interface  VotingDao extends AutoCloseable{

    @SqlQuery("select * from voting where votingId = :id")
    Voting findVotingById(@Bind("id") int votingId);

    @SqlUpdate("Insert into voting (createdBy, createdOn, userId, like) value (:createdBy, :createdOn, :startDate, :location) ; SELECT LAST_INSERT_ID() from voting")
    int newVoting(@Bind("createdBy") int createdBy,
                 @Bind("createdOn") Date createdOn,
                 @Bind("startDate") Date startDate,
                 @Bind("location") String location);

    @SqlUpdate("delete from voting where votingId = :id")
    void deleteVotingById(@Bind("id") int votingId);
}
