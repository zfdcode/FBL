package com.tum.fbl.core.persistence.voting;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper( VotingMapper.class)
public interface  VotingDao extends AutoCloseable{

    @SqlQuery("select * from voting where votingId = :id")
    Category find VotingById(@Bind("id") int votingId);

    @SqlUpdate("Insert into voting (createdBy, createdOn, userId, like) value (:createdBy, :createdOn, :startDate, :location)")
    void new Voting(@Bind("createdBy") int createdBy,
                 @Bind("createdOn") Date createdOn,
                 @Bind("startDate") Date startDate,
                 @Bind("location") String location);

    @SqlUpdate("delete from voting where votingId = :id")
    void delete VotingById(@Bind("id") int votingId);
}
