package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.HealthData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by patrickmelchner on 23.05.17.
 */

@Path("/healthData")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Health API", description = "Provides the health status of the service.")
public class HealthDataResource {

    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic service status")
    public HealthData getHealthDataStatus (@PathParam("userId") int userId) {
        return null;
    }

    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Deletes a health data by user ID")
    public void deleteHealthDataByUserId(@PathParam("userId") int userId) {

    }

    @POST
    @ApiOperation(value = "Add a new healthData to the store")
    public void addHealthData(HealthData healthData) {
    }

    @PUT
    @ApiOperation(value = "Update an existing healthData")
    public void updateHealthData(HealthData healthData) {
    }

}
