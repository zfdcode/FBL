package com.tum.fbl.core.persistence.VotingIngItem;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by marcel on 09.07.2017.
 */

@RegisterMapper( VotingIngItemMapper.class)
public interface VotingIngItemDao extends AutoCloseable{

    @SqlQuery("select * from votingIngItem where votingPeriodId = :votingPeriodId")
    List<VotingIngItem> findVotingIngItemsByPeriod(@Bind("votingPeriodId") int votingPeriodId);

    @SqlQuery("select * from votingIngItem where votingIngItemId = :id")
    VotingIngItem findVotingIngItemById(@Bind("id") int votingIngItemId);

    @GetGeneratedKeys
    @SqlUpdate("Insert into votingIngItem (votingIngItemId, votingPeriodId, isIgnored, ingredientId) value (:votingIngItemId, :votingPeriodId, :isIgnored, :ingredientId)")
    int newVotingIngItem(
                    @Bind("votingIngItemId") int votingIngItemId,
                    @Bind("votingPeriodId") int votingPeriodId,
                    @Bind("isIgnored") boolean isIgnored,
                    @Bind("ingredientId") int ingredientId);

    @SqlUpdate("delete from votingIngItem where votingIngItemId = :id")
    void deleteVotingIngItemById(@Bind("id") int votingIngItemId);

    void close();
}
