package com.tum.fbl.core.persistence.tag;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */

@RegisterMapper(TagMapper.class)
public interface TagDao extends AutoCloseable{

    @SqlQuery("select * from tag where tagId = :id")
    Category findTagById(@Bind("id") int tagId);

    @SqlUpdate("Insert into tag (tagName) value (:tagName)")
    void newTag(@Bind("tagName") int tagName);

    @SqlUpdate("delete from tag where tagId = :id")
    void deleteTagById(@Bind("id") int tagId);
}
