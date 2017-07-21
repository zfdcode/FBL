package com.tum.fbl.core.persistence.VotingOrderList;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by marcel on 09.07.2017.votingOrderListId, float orderedAmount, Date orderedAt, int votingPeriodId
 */

@RegisterMapper( VotingOrderListMapper.class)
public interface VotingOrderListDao extends AutoCloseable{

    @SqlQuery("select * from votingOrderList where votingOrderListId = :id")
    VotingOrderList findVotingOrderListById(@Bind("id") int votingOrderListId);

    @SqlQuery("select * from votingOrderList where votingPeriodId = :votingPeriodId")
    List<VotingOrderList> findVotingOrderListByPeriod(@Bind("votingPeriodId") int votingPeriodId);

    @SqlUpdate("Insert into votingOrderList (votingOrderListId, orderedAmount, orderedAt, votingPeriodId, ingredientId) value (:votingOrderListId, :orderedAmount, :orderedAt, :votingPeriodId, :ingredientId)")
    void newVotingOrderList(
                    @Bind("votingOrderListId") int votingOrderListId,
                    @Bind("orderedAmount") float orderedAmount,
                    @Bind("orderedAt") Date orderedAt,
                    @Bind("votingPeriodId") int votingPeriodId,
                    @Bind("ingredientId") int ingredientId);

    @SqlUpdate("delete from votingOrderList where votingOrderListId = :id")
    void deleteVotingOrderListById(@Bind("id") int votingOrderListId);

    public void close();
}
