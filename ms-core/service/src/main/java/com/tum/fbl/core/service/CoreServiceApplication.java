package com.tum.fbl.core.service;

import com.tum.fbl.core.service.auth.BasicAuthenticator;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.resources.HealthResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by patrickmelchner on 23.05.17.
 */
public class CoreServiceApplication extends Application<CoreServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new CoreServiceApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CoreServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(CoreServiceConfiguration configuration,
                    Environment environment) {


        Authenticator<BasicCredentials, User> authenticator =  new BasicAuthenticator();
        final BasicCredentialAuthFilter<User> authFilter = new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(authenticator)
                .setRealm("Access Protected Ressource")
                .buildAuthFilter();
        environment.jersey().register(new AuthDynamicFeature(authFilter));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));


        final HealthResource healthResource = new HealthResource();
        environment.jersey().register(healthResource);
    }
}
