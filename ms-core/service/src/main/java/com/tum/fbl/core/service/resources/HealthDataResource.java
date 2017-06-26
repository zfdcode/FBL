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
 */

@Path("/healthData")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Health API", description = "Provides the health status of the service.")
public class HealthDataResource {

    private final ConnectionFactory connectionFactory;

    public HealthDataResource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Get basic service status")
    public HealthData getHealthDataStatus(@PathParam("userId") int userId) {
        try (HealthDataDao healthDataDao = this.connectionFactory.getConnection().open(HealthDataDao.class)) {
            com.tum.fbl.core.persistence.healthdata.HealthData healthData = healthDataDao.findHealthDataById(userId);

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

    }

    @DELETE
    @Path("/{userId}")
    @ApiOperation(value = "Deletes a health data by user ID")
    public void deleteHealthDataByUserId(@PathParam("userId") int userId) {
        try (HealthDataDao healthDataDao = this.connectionFactory.getConnection().open(HealthDataDao.class)){
            com.tum.fbl.core.persistence.healthdata.HealthData healthData = healthDataDao.findHealthDataById(userId);
            healthDataDao.deleteHealthData(userId);
        }
    }


    @POST
    @ApiOperation(value = "Add a new healthData to the store")
    public void addHealthData(HealthData healthData) {
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
    }

    @PUT
    @ApiOperation(value = "Update an existing healthData")
    public void updateHealthData(HealthData healthData) {
    }

}
