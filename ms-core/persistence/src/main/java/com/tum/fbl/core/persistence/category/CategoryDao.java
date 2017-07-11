package com.tum.fbl.core.persistence.category;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by malte on 13.06.2017.
 */
@RegisterMapper(CategoryMapper.class)
public interface CategoryDao extends AutoCloseable{


    @SqlQuery("select * from category c where categoryId = :id")
    Category findCategoryById(@Bind("id") int categoryId);

    @SqlQuery("select * from category")
    List<Category> getallCategories();

    @SqlQuery("select c.categoryId, c.categoryName, categoryDescription from (select * from UserCategory where userId = :id) natural join category c")
    List<Category> getCategoriesOfUser(@Bind("id") int userId);

    @SqlQuery("select c.categoryId, c.categoryName, categoryDescription from (select * from MealCategory where mealId = :id) natural join category c")
    List<Category> getCategoriesByMeal(@Bind("id") int mealId);

    @SqlUpdate("Insert into ingredient (categoryName, categoryDescription) value (:categoryName, :categoryDescription); SELECT LAST_INSERT_ID() from category")
    int newCategory(@Bind("categoryName") String categoryName, @Bind("categoryDescription") String categoryDescription);

    @SqlUpdate("update category set categoryName= :categoryName, categoryDescription= :categoryDescription  where categoryId = :id")
    void updateCategory(@Bind("categoryName") String categoryName, @Bind("categoryDescription") String categoryDescription, @Bind("id") int categoryId);


    @SqlUpdate("delete from category where categoryId = :id")
    void deleteCategoryById(@Bind("id") int categoryId);


    void close();
}
