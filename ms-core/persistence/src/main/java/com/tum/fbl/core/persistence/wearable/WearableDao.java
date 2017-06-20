package com.tum.fbl.core.persistence.wearable;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(WearableMapper.class)
public interface WearableDao extends AutoCloseable{

    @SqlQuery("select * from wearable where deviceId = :id")
    Wearable findWearableById(@Bind("id") int deviceId);

    @SqlUpdate("Insert into wearable (diviceType, connectionTime, exitTime, deviceUserId, deviceUserPassword) " +
            "value (:diviceType, :connectionTime, :exitTime, :deviceUserId, :deviceUserPassword)")
    void newWearable(@Bind("diviceType") int diviceType,
                       @Bind("connectionTime") Date connectionTime,
                       @Bind("exitTime") Date exitTime,
                       @Bind("deviceUserId") int deviceUserId,
                       @Bind("deviceUserPassword") String deviceUserPassword);

    @SqlUpdate("delete from wearable where deviceId = :id")
    void deleteWearableById(@Bind("id") int deviceId);
}
