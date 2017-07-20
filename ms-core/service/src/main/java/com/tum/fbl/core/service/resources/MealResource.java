package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.*;
import com.tum.fbl.core.bdo.Category;
import com.tum.fbl.core.bdo.Ingredient;
import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.config.ImageUploadConfiguration;
import com.tum.fbl.core.imagestorage.ImagePersistenceException;
import com.tum.fbl.core.imagestorage.ImageStatus;
import com.tum.fbl.core.imagestorage.ImageStorage;
import com.tum.fbl.core.imagestorage.ImageStorageImpl;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.category.*;
import com.tum.fbl.core.persistence.ingredient.*;
import com.tum.fbl.core.persistence.meal.*;
import com.tum.fbl.core.persistence.rating.*;
import com.tum.fbl.core.persistence.rating.Rating;
import com.tum.fbl.core.persistence.user.*;
import com.tum.fbl.core.service.exceptions.IllegalArgumentExpection;
import com.tum.fbl.core.service.exceptions.ImageException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Documented by jie on 03.07.2017.
 */

@Path("/meal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Meal API", description = "Provides offered meal/menues.")
public class MealResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealResource.class);

    private ImageStorage imageStorage;

    private final ConnectionFactory connectionFactory;

    /**
     * Connects to the factory for meal resource.
     *
     * @param connectionFactory the connection of factory
     */
    public MealResource(ConnectionFactory connectionFactory, ImageUploadConfiguration imageUploadConfiguration) {
        this.connectionFactory = connectionFactory;

        this.imageStorage = new ImageStorageImpl(imageUploadConfiguration);
    }

    /**
     * Gets all meals.
     *
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered meals")
    public List<Meal> getAllMeals() {
        try (
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
                IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
                CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
                RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class);
        ) {
            List<Meal> meals = new ArrayList<>();
            List<com.tum.fbl.core.persistence.meal.Meal> mealsList = mealDao.getAllMeals();

            if (mealsList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealsList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }


    }

    @GET
    @Path("/{attributeName}/{attributeId}")
    @ApiOperation(value = "Get all meals where the int attributeName = attributeId")
    public List<Meal> getMealsByAttributeId(@PathParam("attributeName") String attributeName, @PathParam("attributeId") int attributeId) {
        try (
                MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
                IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
                CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
                RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
                UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.findMealsByAttributte(attributeName, attributeId);

            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);

                }
            }
            return meals;
        }
    }

    @GET
    @Path("/offerDate/{offerDate}/user/{userId}")
    @ApiOperation(value = "Get all meals of one User/Restaurant on one Day")
    public List<Meal> getMealsByOfferDateAndUserId(@PathParam("offerDate") Date offerDate, @PathParam("userId") int userId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealsByUserAndDate(offerDate, userId);

            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @ApiOperation(value = "Get all meals of one Category on one Day")
    @Path("/offerDate/{offerDate}/category/{categoryId}")
    public List<Meal> getMealsByOfferDateAndCategory(@PathParam("offerDate") Date offerDate, @PathParam("categoryId") int categoryId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealsByCategoryAndDate(offerDate, categoryId);

            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/offerDate/{offerDate}")
    @ApiOperation(value = "Get all meals on one Day")
    public List<Meal> getMealsByOfferDate(@PathParam("offerDate") Date offerDate) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getAllMealForDate(offerDate);

            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/rating/{rating}")
    @ApiOperation(value = "Get all meals with a higher rating than X")
    public List<Meal> getMealsByMinRating(@PathParam("rating") float rating) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealByRating(rating);

            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/calories/{calories}")
    @ApiOperation(value = "Get all meals with a fewer calories than X")
    public List<Meal> getMealsByMaxCalories(@PathParam("calories") float calories) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealMaxCalories(calories);

            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/order/{orderId}")
    @ApiOperation(value = "Get all meals by one User/Restaurant")
    public List<Meal> getMealsByOrder(@PathParam("orderId") int orderId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealsByOrder(orderId);
            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/ingredient/{ingredientId}")
    @ApiOperation(value = "Get all meals which contain one ingredient")
    public List<Meal> getMealsByIngredient(@PathParam("ingredientId") int ingredientId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealsByIngredient(ingredientId);
            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/ingredientException/{ingredientId}")
    @ApiOperation(value = "Get all meals which do not contain one ingredient")
    public List<Meal> getMealsByIngredientException(@PathParam("ingredientId") int ingredientId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealsWithIngredientExeption(ingredientId);
            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    @GET
    @Path("/name/{name}")
    @ApiOperation(value = "Get all meals with one Name")
    public List<Meal> getMealsByName(@PathParam("name") String name) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealByName(name);
            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }

    /**
     * Gets meals by user.
     *
     * @param userId the user id
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get information of meals by a user id or restaurant id")
    public List<Meal> getMealsByUser(@PathParam("userId") int userId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)) {
            List<Meal> meals = new ArrayList<>();

            List<com.tum.fbl.core.persistence.meal.Meal> mealList = mealDao.getMealsByUser(userId);
            if (mealList != null) {
                for (com.tum.fbl.core.persistence.meal.Meal meal : mealList) {
                    Meal mealBDO = updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);
                    meals.add(mealBDO);
                }
            }
            return meals;
        }
    }
    /**
     * Gets meal.
     *
     * @param mealId the meal id
     * @return Meal
     */
    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get information of a meal")
    public Meal getMeal(@PathParam("mealId") int mealId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class);
             IngredientDao ingredientDao = this.connectionFactory.getConnection().open(IngredientDao.class);
             CategoryDao categoryDao = this.connectionFactory.getConnection().open(CategoryDao.class);
             RatingDao ratingDao = this.connectionFactory.getConnection().open(RatingDao.class);
             UserDao userDao = this.connectionFactory.getConnection().open(UserDao.class)

        ) {
            com.tum.fbl.core.persistence.meal.Meal meal =  mealDao.findMealById(mealId);
            if (meal != null) {
                return updateMealBDO(meal,ingredientDao,categoryDao,ratingDao,userDao);

            }
            return new Meal();
        }
    }

    /**
     * Deletes meal.
     *
     * @param mealId the meal id
     */
    @DELETE
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Deletes a meal")
    public void deleteMeal(@PathParam("mealId") int mealId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
            mealDao.deleteMealById(mealId);
            mealDao.deleteMealRestaurantById(mealId);
            mealDao.deleteMealIngredientById(mealId);
            mealDao.deleteMealIngredientById(mealId);
        }
    }

    /**
     * Adds image of meal.
     *
     * @param uploadedInputStream the uploaded input stream
     * @param fileDetail          the file detail
     * @return Response
     */
    @Path("/img")
    @POST
    @ApiOperation(value = "Set a meal image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public ImageStatus uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail
    ) {
        try {
            return this.imageStorage.saveImage(uploadedInputStream, fileDetail.getFileName());
        } catch (ImagePersistenceException e) {
            LOGGER.error("Image Upload failed");
            throw new ImageException("File could not be uploaded");
        }
    }

    /**
     * Adds meal.
     *
     * @param meal the meal
     */
    @POST
    @ApiOperation(value = "Add a new meal to the store")
    public int addMeal(Meal meal) throws IllegalArgumentExpection {

        if (meal != null) {
            try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {

                int mealId = mealDao.newMeal(
                            meal.getMealName(),
                            "",
                            meal.getMealRating(),
                            0,
                            meal.getMealPreparationTime(),
                            meal.getOfferDate(),
                            meal.getMealEnergy(),
                            meal.getMealProtein(),
                            meal.getMealTotalFat(),
                            meal.getMealSaturated(),
                            meal.getMealTotalCarbohydrate(),
                            meal.getMealSugar(),
                            meal.getMealSodium(),
                            meal.getMealPrice()
                );
                Restaurant restaurant = meal.getMealRestaurant();

                Category[] categories = meal.getMealCategories();

                Ingredient[] ingredients = meal.getMealIngredients();

                com.tum.fbl.core.bdo.Rating[] ratings = meal.getMealRatings();

                mealDao.newRestaurantMeal(mealId, restaurant.getRestaurantId(), meal.getOfferDate());

                if(categories!=null){
                    for(Category c: categories){
                        mealDao.newMealCategory(mealId, c.getCategoryId());
                    }
                }

                if(ingredients!=null){
                    for(Ingredient i: ingredients){
                        mealDao.newMealIngredient(mealId, i.getIngredientId());
                    }
                }


                return mealId;
            }
        } else {
            throw new IllegalArgumentExpection();
        }

    }

    /**
     * Updates meal.
     *
     * @param meal the meal
     */
    @PUT
    @ApiOperation(value = "Update an existing meal")
    public void updateMeal(Meal meal) {

        if (meal != null) {
            try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {

                 mealDao.updateMeal(
                         meal.getMealName(),
                        "",
                        meal.getMealRating(),
                        0,
                        meal.getMealPreparationTime(),
                        meal.getOfferDate(),
                        meal.getMealEnergy(),
                        meal.getMealProtein(),
                        meal.getMealTotalFat(),
                        meal.getMealSaturated(),
                        meal.getMealTotalCarbohydrate(),
                        meal.getMealSugar(),
                        meal.getMealSodium(),
                        meal.getMealPrice(),
                        meal.getMealId()
                );
            }
        } else {
            throw new IllegalArgumentExpection();
        }
    }

    private Meal updateMealBDO(com.tum.fbl.core.persistence.meal.Meal meal, IngredientDao ingredientDao,
                               CategoryDao categoryDao, RatingDao ratingDao, UserDao userDao){
        Meal mealBDO = new Meal(meal);
        //add ingredients
        List<com.tum.fbl.core.persistence.ingredient.Ingredient> ingredients = ingredientDao.getIngredientsByMealID(meal.getMealId());
        if (ingredients!=null){
            List<Ingredient> ingredientList = new ArrayList<>();
            //for all ingredients with this mealId
            for (com.tum.fbl.core.persistence.ingredient.Ingredient ingredient:ingredients){
                //create new ingredient bdo and add it into ingredientList
                ingredientList.add(new Ingredient(ingredient));
            }
            //set mealBDO ingredients infos
            mealBDO.setMealIngredients(ingredientList.toArray(new Ingredient[ingredientList.size()]));
        }
        //add category
        List<com.tum.fbl.core.persistence.category.Category> categories = categoryDao.getCategoriesByMeal(meal.getMealId());
        if (categories!=null){
            List<Category> categoryList = new ArrayList<>();
            for (com.tum.fbl.core.persistence.category.Category category:categories){
                categoryList.add(new Category(category));
            }
            mealBDO.setMealCategories(categoryList.toArray(new Category[categoryList.size()]));
        }

        //add rating
        float mealRating = 0;
        List<com.tum.fbl.core.persistence.rating.Rating> ratings = ratingDao.findRatingsByMealId(meal.getMealId());
        if (ratings != null) {
            int positiveRatings = 0;
            for (Rating raing : ratings) {
                if (raing.isRating()){
                    positiveRatings++;
                }
            }
            mealRating=positiveRatings/ratings.size();
        }
        meal.setMealRating(mealRating);

        //add restaurant
        com.tum.fbl.core.persistence.user.User restaurant = userDao.findUserByMealId(meal.getMealId());
        if (restaurant!=null){
            mealBDO.setMealRestaurant(new Restaurant(restaurant));
        }
        return mealBDO;
    }
}
