package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.HealthData;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.persistence.healthdata.HealthDataDao;
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
     * Connects to the factory for health data resource.
     * @param connectionFactory the connection of factory
     */
    public HealthDataResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets health data status.
     * @param userId the user id
     * @return health data
     */
    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic service status")
    public HealthData getHealthDataStatus(@PathParam("userId") int userId) {
        try (HealthDataDao healthDataDao = this.connectionFactory.getConnection().open(HealthDataDao.class)) {
            com.tum.fbl.core.persistence.healthdata.HealthData healthData = healthDataDao.findHealthDataById(userId);

            /*
            return new HealthData(
                    healthData.getUserId(),
                    healthData.getDeviceUserPassword(),
                    healthData.getDeviceUserId(),
                    healthData.getCurrentHearthbeat(),
                    healthData.getHeartbeatTimeRange(),
                    healthData.getTrackedCalorieToday(),
                    healthData.getTrackedCaloriesTimeRange(),
                    healthData.getAverageHeartbeatTimeRange()
            );

        }
        */

            return null;

        }
    }

    /**
     * Deletes health data by user id.
     * @param userId the user id
     */
    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Deletes a health data by user ID")
    public void deleteHealthDataByUserId(@PathParam("userId") int userId) {
        try (HealthDataDao healthDataDao = this.connectionFactory.getConnection().open(HealthDataDao.class)){
            com.tum.fbl.core.persistence.healthdata.HealthData healthData = healthDataDao.findHealthDataById(userId);
            healthDataDao.deleteHealthData(userId);
        }
    }

    /**
     * Adds health data.
     * @param healthData the health data
     */
    @POST
    @ApiOperation(value = "Add a new healthData to the store")
    public void addHealthData(HealthData healthData) {

        /*
        try (HealthDataDao healthDataDao = this.connectionFactory.getConnection().open(HealthDataDao.class)){
            healthDataDao.newHealthData(
                    healthData.getUserId(),
                    healthData.getDeviceUserPassword(),
                    healthData.getDeviceUserId(),
                    healthData.getCurrentHearthbeat(),
                    healthData.getHeartbeatTimeRange(),
                    healthData.getTrackedCalorieToday(),
                    healthData.getTrackedCaloriesTimeRange(),
                    healthData.getAverageHeartbeatTimeRange()
            );
        }
        */

    }

    /**
     * Updates health data.
     * @param healthData the health data
     */
    @PUT
    @ApiOperation(value = "Update an existing healthData")
    public void updateHealthData(HealthData healthData) {
    }

    @GET
    @Path("/leftCalories")
    @ApiOperation(value = "get left calories by user")
    public HealthData getLeftCalories(int userId){
        return null;
    }

}
