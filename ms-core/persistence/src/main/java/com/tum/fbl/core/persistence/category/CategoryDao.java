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


    @SqlQuery("select * from Category c where categoryId = :id")
    Category findCategoryById(@Bind("id") int categoryId);

    /**
     * gets all categories from database
     * @return List of Category objects
     */
    @SqlQuery("select * from category")
    List<Category> getallCategories();

    /**
     * gets categories of a user from the database
     * @param userId the user's unique ID
     * @return List of Category objects
     */
    @SqlQuery("select c.categoryId, c.categoryName, categoryDescription from (select * from UserCategory where userId = :id) natural join category c")
    List<Category> getCategoriesOfUser(@Bind("id") int userId);

    /**
     * gets categories a meal is in from the database
     * @param mealId the meal's unique ID
     * @return List of Category objects
     */
    @SqlQuery("select c.categoryId, c.categoryName, categoryDescription from (select * from MealCategory where mealId = :id) natural join category c")
    List<Category> getCategoriesByMeal(@Bind("id") int mealId);

    /**
     * inserts new category into database
     * @param categoryName the new category's name
     * @param categoryDescription the new category's description
     */
    @SqlUpdate("Insert into Category (categoryName, categoryDescription) values (:categoryName, :categoryDescription); SELECT LAST_INSERT_ID() from userCategory")
    int newCategory(@Bind("categoryName") String categoryName, @Bind("categoryDescription") String categoryDescription);

    /**
     * updates an existing category in the database
     * @param categoryName the new name of the category
     * @param categoryDescription the new description of the category
     * @param categoryId the unique ID of the category that will be updated
     */
    @SqlUpdate("update Category set categoryName= :categoryName, categoryDescription= :categoryDescription  where categoryId = :id")
    void updateCategory(@Bind("categoryName") String categoryName, @Bind("categoryDescription") String categoryDescription, @Bind("id") int categoryId);

    /**
     * deletes an entry in the category table in the database
     * @param categoryId the unique ID of the category that will be deleted
     */
    @SqlUpdate("delete from Category where categoryId = :id")
    void deleteCategoryById(@Bind("id") int categoryId);


    void close();
}
