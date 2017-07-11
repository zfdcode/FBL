package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.config.ImageUploadConfiguration;
import com.tum.fbl.core.imagestorage.ImagePersistenceException;
import com.tum.fbl.core.imagestorage.ImageStatus;
import com.tum.fbl.core.imagestorage.ImageStorage;
import com.tum.fbl.core.imagestorage.ImageStorageImpl;
import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.meal.MealDao;
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
     * @param connectionFactory the connection of factory
     */
    public MealResource(ConnectionFactory connectionFactory, ImageUploadConfiguration imageUploadConfiguration) {
        this.connectionFactory = connectionFactory;

        this.imageStorage = new ImageStorageImpl(imageUploadConfiguration);
    }

    /**
     * Gets all meals.
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered meals")
    public List<Meal> getAllMeals() {
        //TODO: return list meal
        return null;
    }

    @GET
    @Path("/{attributeName}/{attributeId}")
    public List<Meal> getMealsByAttributeId(@PathParam("attributeName") String attributeName, @PathParam("attributeId") int attributeId){
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
            List<Meal> meals = new ArrayList<>();
            for (com.tum.fbl.core.persistence.meal.Meal meal:mealDao.findMealsByAttributte(attributeName,attributeId)){
                meals.add(new Meal(meal));
            }
            return meals;
        }
    }

    @GET
    @Path("/offerDate/{offerDate}/user/{userId}")
    public List<Meal> getMealsByOfferDateAndUserId(){return null;}

    @GET
    @Path("/offerDate/{offerDate}/category/{categoryId}")
    public List<Meal> getMealsByOfferDateAndCategory(){return null;}

    @GET
    @Path("/offerDate/{offerDate}")
    public List<Meal> getMealsByOfferDate(){return null;}

    @GET
    @Path("/rating/{rating}")
    public List<Meal> getMealsByRating(){return null;}

    @GET
    @Path("/calories/{calories}")
    public List<Meal> getMealsByCalories(){return null;}

    @GET
    @Path("/order/{orderId}")
    public List<Meal> getMealsByOrder(){return null;}

    @GET
    @Path("/ingredient/{ingredientId}")
    public List<Meal> getMealsByIngredient(){return null;}

    @GET
    @Path("/ingredientException/{ingredientIds}")
    public List<Meal> getMealsByIngredientExceptions(){return null;}

    @GET
    @Path("/name/{name}")
    public List<Meal> getMealsByName(){return null;}

    /**
     * Gets meals by user.
     * @param userId the user id
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get information of meals by a user id or restaurant id")
    public List<Meal> getMealsByUser(@PathParam("userId") int userId) {
        return null;
    }

    /**
     * Gets meal.
     * @param mealId the meal id
     * @return Meal
     */
    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get information of a meal")
    public Meal getMeal(@PathParam("mealId") int mealId) {

        /*
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
            com.tum.fbl.core.persistence.meal.Meal meal = mealDao.findMealById(mealId);
            return new Meal(
                    meal.getMealId(),
                    meal.getMealName(),
                    meal.getMealImage(),
                    meal.getMealRating(),
                    meal.getMealHelathValue(),
                    meal.getMealPreparationTime(),
                    meal.getOfferDate(),
                    meal.getMealEnergy(),
                    meal.getMealProtein(),
                    meal.getMealTotalFat(),
                    meal.getMealSaturated(),
                    meal.getMealTotalCarbohydrate(),
                    meal.getMealSugar(),
                    meal.getMealSodium(),
                    //TODO:
                    null,
                    null,
                    null
            );
            */
        return null;

    }

    /**
     * Deletes meal.
     * @param mealId the meal id
     */
    @DELETE
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Deletes a meal")
    public void deleteMeal(@PathParam("mealId") int mealId) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
            mealDao.deleteMealById(mealId);
        }
    }

    /**
     * Adds image of meal.
     * @param uploadedInputStream the uploaded input stream
     * @param fileDetail the file detail
     * @return Response
     */
    @Path("/img")
    @POST
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
     * @param meal the meal
     */
    @POST
    @ApiOperation(value = "Add a new meal to the store")
    public int addMeal(Meal meal) {

        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
           return mealDao.newMeal(
                    meal.getMealName(),
                    null,
                    meal.getMealRating(),
                    0,
                    meal.getMealPreparationTime(),
                    null,
                    meal.getMealEnergy(),
                    meal.getMealProtein(),
                    meal.getMealTotalFat(),
                    meal.getMealSaturated(),
                    meal.getMealTotalCarbohydrate(),
                    meal.getMealSugar(),
                    meal.getMealSodium()
            );
        }

    }

    /**
     * Updates meal.
     * @param meal the meal
     */
    @PUT
    @ApiOperation(value = "Update an existing meal")
    public void updateMeal(Meal meal) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)){
            //TODO:update
        }
    }
}
