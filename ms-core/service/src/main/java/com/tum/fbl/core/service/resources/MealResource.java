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


@Path("/meal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Meal API", description = "Provides offered meal/menues.")
public class MealResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealResource.class);

    private ImageStorage imageStorage;

    private final ConnectionFactory connectionFactory;


    public MealResource(ConnectionFactory connectionFactory, ImageUploadConfiguration imageUploadConfiguration) {
        this.connectionFactory = connectionFactory;

        this.imageStorage = new ImageStorageImpl(imageUploadConfiguration);
    }

    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered meals")
    public List<Meal> getAllMeals(@Auth User user) {
        return null;
    }

    @GET
    @Path("/available")
    @ApiOperation(value = "Get all available meals")
    public List<Meal> getAvailableMeals(@Auth User user) {
        return null;
    }

    @GET
    @Path("/user/{userId}")
    @ApiOperation(value = "Get information of meals by one user")
    public List<Meal> getMealsByUser(@PathParam("userId") int userId){
        return null;
    }

    @GET
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Get information of a meal")
    public Meal getMeal(@PathParam("mealId") int mealId){
        return null;
    }

    @DELETE
    @Path("/meal/{mealId}")
    @ApiOperation(value = "Deletes a meal")
    public void deleteMeal(@PathParam("mealId") int mealId) {

    }

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

    @POST
    @ApiOperation(value = "Add a new meal to the store")
    public void addMeal(Meal meal) {
    }

    @PUT
    @ApiOperation(value = "Update an existing meal")
    public void updateMeal(Meal meal) {
    }
}
