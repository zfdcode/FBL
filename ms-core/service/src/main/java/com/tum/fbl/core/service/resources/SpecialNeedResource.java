package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.bdo.SpecialNeed;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
/**
 * Created by zfngd on 2017/6/15.
 */
@Path("/specialNeed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "special need API", description = "Provides special needs.")
public class SpecialNeedResource {

    private final ConnectionFactory connectionFactory;

    public SpecialNeedResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Path("/all")
    @ApiOperation(value = "Get all offered specialNeeds")
    public List<SpecialNeed> getAllSpecialNeeds(@Auth User user) {
        return null;
    }

    @GET
    @Path("/{specialNeedId}")
    @ApiOperation(value = "Get information of a specialNeed")
    public SpecialNeed getSpecialNeed(@PathParam("specialNeedId") int specialNeedId){
        return null;
    }

    @DELETE
    @Path("/{specialNeedId}")
    @ApiOperation(value = "Deletes a special need")
    public void deleteSpecialNeed(@PathParam("specialNeedId") int specialNeedId) {

    }

    @ApiOperation(value = "Add a new special need to the store")
    public void addSpecialNeed(SpecialNeed specialNeed) {
    }

    @PUT
    @ApiOperation(value = "Update an existing special need")
    public void updateSpecialNeed(SpecialNeed specialNeed) {
    }


}
