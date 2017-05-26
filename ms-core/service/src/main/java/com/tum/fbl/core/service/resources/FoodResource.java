package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/food")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Food API", description = "Provides offered food/menues.")
public class FoodResource {

    @GET
    @ApiOperation(value = "Get all offered food/menues")
    public String getAllMenus(@Auth User user) {
        return "running";
    }
}
