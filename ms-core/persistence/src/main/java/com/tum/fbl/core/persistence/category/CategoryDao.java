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


    @SqlQuery("select * from category c where categoryId = :id")
    Category findCategoryById(@Bind("id") int userId);

    @SqlQuery("select c.categoryId, c.categoryName, categoryDescription from (select * from UserCategory where userId = :id) natural join category c")
    Category getCategoriesOfUser(@Bind("id") int categoryId);

    @SqlUpdate("Insert into ingredient (categoryName, categoryDescription) value (:categoryName, :categoryDescription)")
    void newCategory(@Bind("categoryName") String categoryName, @Bind("categoryDescription") String categoryDescription);

    @SqlUpdate("delete from category where categoryId = :id")
    void deleteCategoryById(@Bind("id") int categoryId);

    @SqlUpdate("Select * from (select * from category where categroyId = :id) natural join categoryMeal natural join meal")
    void getMealsByCategoryId(@Bind("id") int categoryId);
}
