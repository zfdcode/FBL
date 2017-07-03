package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.imagestorage.ImagePersistenceException;
import com.tum.fbl.core.imagestorage.ImageStatus;
import com.tum.fbl.core.imagestorage.ImageStorage;
import com.tum.fbl.core.imagestorage.ImageStorageImpl;
import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.meal.MealDao;
import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;


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
    public MealResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;

        this.imageStorage = new ImageStorageImpl();
    }

    /**
     * Gets all meals.
     * @param user the user
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered meals")
    public List<Meal> getAllMeals(@Auth User user) {
        //TODO: return list meal
        return null;
    }

    /**
     * Gets available meals.
     * @param user the user
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/available")
    @ApiOperation(value = "Get all available meals")
    public List<Meal> getAvailableMeals(@Auth User user) {
        return null;
    }

    /**
     * Gets meals by user.
     * @param userId the user id
     * @return List<Meal> the list of meals
     */
    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get information of meals by one user")
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
        }
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
            mealDao.delteMealById(mealId);
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
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail
    ) {
        try {
            final ImageStatus imageStatus = this.imageStorage.saveImage(uploadedInputStream);
            return Response.ok().build();
        } catch (ImagePersistenceException e) {
            LOGGER.error("Image Upload failed");
            return Response.serverError().build();
        }
    }

    /**
     * Adds meal.
     * @param meal the meal
     */
    @POST
    @ApiOperation(value = "Add a new meal to the store")
    public void addMeal(Meal meal) {
        try (MealDao mealDao = this.connectionFactory.getConnection().open(MealDao.class)) {
            mealDao.newMeal(
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
