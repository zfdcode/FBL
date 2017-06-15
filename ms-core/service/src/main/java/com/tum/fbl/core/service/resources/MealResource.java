package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.imagestorage.ImagePersistenceException;
import com.tum.fbl.core.imagestorage.ImageStatus;
import com.tum.fbl.core.imagestorage.ImageStorage;
import com.tum.fbl.core.imagestorage.ImageStorageImpl;
import com.tum.fbl.core.bdo.Meal;
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
@Api(value = "Meal API", description = "Provides offered meal/menues.")
public class MealResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealResource.class);

    private ImageStorage imageStorage;

    public MealResource() {
        this.imageStorage = new ImageStorageImpl();
    }

    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered meal/menues")
    public List<Meal> getAllMeals(@Auth User user) {
        return null;
    }

    @GET
    @Path("/{mealId}")
    @ApiOperation(value = "Get information of a meal")
    public Meal getMeal(@PathParam("mealId") int mealId){
        return null;
    }

    @DELETE
    @Path("/{mealId}")
    @ApiOperation(value = "Deletes a meal")
    public void deleteMeal(@PathParam("mealId") int mealId) {

    }

    @Path("/img")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail
    ){
        try {
            final ImageStatus imageStatus = this.imageStorage.saveImage(uploadedInputStream);
            return Response.ok().build();
        } catch (ImagePersistenceException e) {
            LOGGER.error("Image Upload failed");
            return  Response.serverError().build();
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Add a new meal to the store")
    public void addMeal(Meal meal) {
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Update an existing meal")
    public void updateMeal(Meal meal) {
    }
}
