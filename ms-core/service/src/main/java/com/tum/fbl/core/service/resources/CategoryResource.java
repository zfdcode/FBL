package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.Category;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.category.CategoryDao;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfngd on 2017/6/15.
 */
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Category API", description = "Provides meal categories.")
public class CategoryResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects to the factory for speacial need resource.
     *
     * @param connectionFactory the connection of factory
     */
    public CategoryResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all special needs.
     *
     * @return List<Category> the list of special needs
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered categories")
    public List<Category> getAllCategorys() {
        try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {
            List<com.tum.fbl.core.persistence.category.Category> categories = categoryDao.getallCategories();

            List<Category> categoriesBdo = new ArrayList<>();

            if (categories != null) {
                for (com.tum.fbl.core.persistence.category.Category category : categories) {
                    Category newCategory = new Category(category);
                    categoriesBdo.add(newCategory);
                }
            }

            return categoriesBdo;
        }
    }

    /**
     * Gets special need.
     *
     * @param categoryId the special need id
     * @return Category the speical need
     */
    @GET
    @Path("/{categoryId}")
    @ApiOperation(value = "Get information of a category")
    public Category getCategory(@PathParam("categoryId") int categoryId) {
        try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {

            com.tum.fbl.core.persistence.category.Category category = categoryDao.findCategoryById(categoryId);
            if (category != null) {
                return new Category(categoryDao.findCategoryById(categoryId));
            } else {
                return null;
            }
        }
    }

    @GET
    @Path("user/{userId}")
    @ApiOperation(value = "Get information of categories by uerId")
    public List<Category> getCategoriesByUserId(@PathParam("userId") int userId) {
        try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {
            List<Category> categories = new ArrayList<>();

            List<com.tum.fbl.core.persistence.category.Category> categoriesDb = categoryDao.getCategoriesOfUser(userId);
            if (categoriesDb != null) {
                for (com.tum.fbl.core.persistence.category.Category category : categoriesDb) {
                    categories.add(new Category(category));
                }
            }

            return categories;
        }
    }

    @GET
    @Path("meal/{mealId}")
    @ApiOperation(value = "Get categories of one Meal")
    public List<Category> getCategoriesByMealId(@PathParam("mealId") int mealId) {
        try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {
            List<Category> categories = new ArrayList<>();

            List<com.tum.fbl.core.persistence.category.Category> categoriesDb = categoryDao.getCategoriesByMeal(mealId);
            if (categoriesDb != null) {
                for (com.tum.fbl.core.persistence.category.Category category : categoriesDb) {
                    categories.add(new Category(category));
                }
            }

            return categories;
        }
    }

    /**
     * Deletes special need.
     *
     * @param categoryId the special need id
     */
    @DELETE
    @Path("/{categoryId}")
    @ApiOperation(value = "Deletes a special need")
    public void deleteCategory(@PathParam("categoryId") int categoryId) {
        try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {
            categoryDao.deleteCategoryById(categoryId);
        }
    }

    /**
     * Adds special need.
     *
     * @param category the speical need
     */
    @POST
    @ApiOperation(value = "Add a new category to the store")
    public int addCategory(Category category) throws IllegalArgumentExpection {
        try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {

            if (category != null) {
                return categoryDao.newCategory(category.getCategoryName(), category.getCategoryDescription());
            } else {
                throw new IllegalArgumentExpection();
            }
        }
    }

    /**
     * Updates special need.
     *
     * @param category the special need
     */
    @PUT
    @ApiOperation(value = "Update an existing category")
    public void updateCategory(Category category) throws IllegalArgumentExpection {
        if (category != null) {
            try (CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class)) {
                categoryDao.updateCategory(
                        category.getCategoryName(),
                        category.getCategoryDescription(),
                        category.getCategoryId());
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

}
