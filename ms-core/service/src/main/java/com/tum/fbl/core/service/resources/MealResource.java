package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.config.ImageUploadConfiguration;
import com.tum.fbl.core.imagestorage.ImagePersistenceException;
import com.tum.fbl.core.imagestorage.ImageStatus;
import com.tum.fbl.core.imagestorage.ImageStorage;
import com.tum.fbl.core.imagestorage.ImageStorageImpl;
import com.tum.fbl.core.bdo.Meal;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.exceptions.ImageException;
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
     * Connects the factory for meal resource.
     * @param connectionFactory the connection factory
     */
    public MealResource(ConnectionFactory connectionFactory, ImageUploadConfiguration imageUploadConfiguration) {
        this.connectionFactory = connectionFactory;

        this.imageStorage = new ImageStorageImpl(imageUploadConfiguration);
    }

    /**
     * Gets all meals.
     * @return null
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered meals")
    public List<Meal> getAllMeals() {
        return null;
    }

    /**
     * Gets available meals.
     * @return null
     */
    @GET
    @Path("/available")
    @ApiOperation(value = "Get all available meals")
    public List<Meal> getAvailableMeals() {
        return null;
    }

    /**
     * Gets meals by user.
     * @param userId the user id
     * @return list of meal
     */
    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get information of meals by one user")
    public List<Meal> getMealsByUser(@PathParam("userId") int userId){
        return null;
    }

    /**
     * Gets meal.
     * @param mealId the meal id
     * @return meal
     */
    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get information of a meal")
    public Meal getMeal(@PathParam("mealId") int mealId){
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

    }

    /**
     * Adds image of the meal.
     * @param uploadedInputStream the uploaded input stram
     * @param fileDetail the file detail
     * @return image status
     */
    @Path("/img")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public ImageStatus uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail
    ){
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
    public void addMeal(Meal meal) {
    }

    /**
     * Updates meal.
     * @param meal the meal
     */
    @PUT
    @ApiOperation(value = "Update an existing meal")
    public void updateMeal(Meal meal) {
    }
}
