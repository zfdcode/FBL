package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.imagestorage.ImagePersistenceException;
import com.tum.fbl.core.imagestorage.ImageStatus;
import com.tum.fbl.core.imagestorage.ImageStorage;
import com.tum.fbl.core.imagestorage.ImageStorageImpl;
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


@Path("/food")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Food API", description = "Provides offered food/menues.")
public class FoodResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodResource.class);

    private ImageStorage imageStorage;

    public FoodResource () {
        this.imageStorage = new ImageStorageImpl();
    }

    @GET
    @ApiOperation(value = "Get all offered food/menues")
    public String getAllMenus(@Auth User user) {
        return "running";
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



}
