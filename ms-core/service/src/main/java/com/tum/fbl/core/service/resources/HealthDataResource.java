package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.HealthData;
import com.tum.fbl.core.persistence.ConnectionFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by patrickmelchner on 23.05.17.
 * Documented by jie on 03.07.2017.
 */

@Path("/healthData")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Health API", description = "Provides the health status of the service.")
public class HealthDataResource {

    private final ConnectionFactory connectionFactory;

    /**
     * Connects the factory for health data resource.
     * @param connectionFactory the connection factory
     */
    public HealthDataResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets HealthDataStatus.
     * @param userId the user id
     * @return health data status
     */
    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic service status")
    public HealthData getHealthDataStatus (@PathParam("userId") int userId) {
        return null;
    }

    /**
     * Deletes Health Data By UserId.
     * @param userId the user id
     */
    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Deletes a health data by user ID")
    public void deleteHealthDataByUserId(@PathParam("userId") int userId) {

    }

    /**
     * Adds health data.
     * @param healthData the health data
     */
    @POST
    @ApiOperation(value = "Add a new healthData to the store")
    public void addHealthData(HealthData healthData) {
    }


    /**
     * Updates health data.
     * @param healthData the health data
     */
    @PUT
    @ApiOperation(value = "Update an existing healthData")
    public void updateHealthData(HealthData healthData) {
    }

}
