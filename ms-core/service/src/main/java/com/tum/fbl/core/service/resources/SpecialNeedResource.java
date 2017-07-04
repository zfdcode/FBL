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

    /**
     * Connects to the factory for speacial need resource.
     * @param connectionFactory the connection of factory
     */
    public SpecialNeedResource (ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * Gets all special needs.
     * @param user the user
     * @return List<SpecialNeed> the list of special needs
     */
    @GET
    @Path("/all")
    @ApiOperation(value = "Get all offered specialNeeds")
    public List<SpecialNeed> getAllSpecialNeeds(@Auth User user) {
        return null;
    }

    /**
     * Gets special need.
     * @param specialNeedId the special need id
     * @return SpecialNeed the speical need
     */
    @GET
    @Path("/{specialNeedId}")
    @ApiOperation(value = "Get information of a specialNeed")
    public SpecialNeed getSpecialNeed(@PathParam("specialNeedId") int specialNeedId){
        return null;
    }

    /**
     * Deletes special need.
     * @param specialNeedId the special need id
     */
    @DELETE
    @Path("/{specialNeedId}")
    @ApiOperation(value = "Deletes a special need")
    public void deleteSpecialNeed(@PathParam("specialNeedId") int specialNeedId) {

    }

    /**
     * Adds special need.
     * @param specialNeed the speical need
     */
    @ApiOperation(value = "Add a new special need to the store")
    public void addSpecialNeed(SpecialNeed specialNeed) {
    }

    /**
     * Updates special need.
     * @param specialNeed the special need
     */
    @PUT
    @ApiOperation(value = "Update an existing special need")
    public void updateSpecialNeed(SpecialNeed specialNeed) {
    }


}
