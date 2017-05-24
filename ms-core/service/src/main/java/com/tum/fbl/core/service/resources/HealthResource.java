package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by patrickmelchner on 23.05.17.
 */

@Path("/health")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Health API", description = "Provides the health status of the service.")
public class HealthResource {

    @GET
    @ApiOperation(value = "Get basic service status")
    public String getHealthStatus (@Auth User user) {
        return "running";
    }
}
