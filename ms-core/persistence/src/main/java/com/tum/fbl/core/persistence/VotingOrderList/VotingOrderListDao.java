package com.tum.fbl.core.persistence.VotingOrderList;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

/**
 * Created by marcel on 09.07.2017.votingOrderListId, float orderedAmount, Date orderedAt, int votingPeriodId
 */

@RegisterMapper( VotingOrderListMapper.class)
public interface VotingOrderListDao extends AutoCloseable{

    @SqlQuery("select * from votingOrderList where votingOrderListId = :id")
    VotingOrderList findVotingOrderListById(@Bind("id") int votingOrderListId);

    @SqlUpdate("Insert into voting (orderedAmount, orderedAt, votingPeriodId) value (:orderedAmount, :orderedAt, :votingPeriodId)")
    void newVoting(@Bind("createdBy") float orderedAmount,
                   @Bind("createdOn") Date orderedAt,
                   @Bind("startDate") int votingPeriodId);

    @SqlUpdate("delete from votingOrderList where votingOrderList = :id")
    void deleteVotingOrderListById(@Bind("id") int votingOrderListId);

    void close();
}
