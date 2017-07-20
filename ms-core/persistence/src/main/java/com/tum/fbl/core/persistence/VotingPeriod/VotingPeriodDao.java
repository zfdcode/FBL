package com.tum.fbl.core.persistence.VotingPeriod;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper( VotingPeriodMapper.class)
public interface VotingPeriodDao extends AutoCloseable{

    @SqlQuery("select * from votingPeriod where isFinished = :isFinished")
    List<VotingPeriod> getAllVotingPeriodsByFinished(@Bind("isFinished") boolean isFinished);

    @SqlQuery("select * from votingPeriod")
    List<VotingPeriod> getAllVotingPeriods();

    @SqlQuery("select * from votingPeriod where votingPeriodId = :id")
    VotingPeriod findVotingPeriodById(@Bind("id") int votingPeriodId);

    @GetGeneratedKeys
    @SqlUpdate("Insert into voting (startTime, endTime, isFinished, calendarWeek) value (:startTime, :endTime, :isFinished, :calendarWeek)")
    int newVoting(@Bind("createdBy") Date startTime,
                   @Bind("createdOn") Date endTime,
                   @Bind("startDate") Boolean isFinished,
                   @Bind("location") int calendarWeek);

    @SqlUpdate("delete from votingPeriod where votingPeriodId = :id")
    void deleteVotingById(@Bind("id") int votingPeriodId);

    void close();
}
