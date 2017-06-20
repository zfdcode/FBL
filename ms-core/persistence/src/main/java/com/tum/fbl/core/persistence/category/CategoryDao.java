package com.tum.fbl.core.persistence.category;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(CategoryMapper.class)
public interface CategoryDao extends AutoCloseable{

    @SqlQuery("select * from category where categoryId = :id")
    Category findCategoryById(@Bind("id") int categoryId);

    @SqlUpdate("Insert into ingredient (categoryName) value (:categoryName)")
    void newCategory(@Bind("categoryName") String categoryName);

    @SqlUpdate("delete from category where categoryId = :id")
    void deleteCategoryById(@Bind("id") int categoryId);
}
