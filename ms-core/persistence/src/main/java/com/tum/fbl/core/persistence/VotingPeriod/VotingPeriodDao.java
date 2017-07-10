package com.tum.fbl.core.persistence.VotingPeriod;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper( VotingPeriodMapper.class)
public interface VotingPeriodDao extends AutoCloseable{

    @SqlQuery("select * from votingPeriod where votingPeriodId = :id")
    VotingPeriod findVotingPeriodById(@Bind("id") int votingPeriodId);

    @SqlUpdate("Insert into voting (startTime, endTime, isFinished, calendarWeek) value (:startTime, :endTime, :isFinished, :calendarWeek)")
    void newVoting(@Bind("createdBy") Date startTime,
                   @Bind("createdOn") Date endTime,
                   @Bind("startDate") Boolean isFinished,
                   @Bind("location") int calendarWeek);

    @SqlUpdate("delete from votingPeriod where votingPeriodId = :id")
    void deleteVotingById(@Bind("id") int votingPeriodId);
}