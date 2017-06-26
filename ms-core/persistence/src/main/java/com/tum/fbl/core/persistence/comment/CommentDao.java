package com.tum.fbl.core.persistence.comment;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by Malte on 26.06.2017.
 */

@RegisterMapper(CommentMapper.class)
public interface CommentDao  extends AutoCloseable{

    @SqlQuery("select * from comment where commentId = :id")
    Comment findCommentById(@Bind("id") int commentId);

    @SqlUpdate("Insert into comment (comment) value (:comment)")
    void newComment(@Bind("comment") int comment);

    @SqlUpdate("delete from comment where commentId = :id")
    void deleteCommentById(@Bind("id") int commentId);


}
