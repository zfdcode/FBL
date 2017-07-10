package com.tum.fbl.core.service.resources;

import com.tum.fbl.core.service.auth.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Authentication API", description = "Provides authentication for other services.")
public class AuthResource {

    private Authenticator<BasicCredentials, User> authenticator;

    public AuthResource (Authenticator<BasicCredentials, User> authenticator) {
        this.authenticator = authenticator;
    }

    @GET
    @Path("/{email}")
    @ApiOperation(value = "Authenticates a user.")
    public boolean getUser(@PathParam("email") String email, @QueryParam("password") String password) {

        BasicCredentials credentials = new BasicCredentials(email, password);
        try {
            Optional<User> user = this.authenticator.authenticate(credentials);
            return user.isPresent();
        } catch (AuthenticationException e) {
            return false;
        }
    }
}
