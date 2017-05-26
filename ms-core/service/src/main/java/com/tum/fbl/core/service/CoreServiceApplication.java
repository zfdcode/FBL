package com.tum.fbl.core.service;

import com.tum.fbl.core.service.auth.BasicAuthenticator;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.resources.FoodResource;
import com.tum.fbl.core.service.resources.HealthResource;
import com.tum.fbl.core.service.resources.OrderResource;
import com.tum.fbl.core.service.resources.RestaurantResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by patrickmelchner on 23.05.17.
 */
public class CoreServiceApplication extends Application<CoreServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new CoreServiceApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CoreServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<CoreServiceConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(CoreServiceConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(CoreServiceConfiguration configuration,
                    Environment environment) {

        registerAuthenticator(environment);

        registerResources(environment);
    }


    private void registerAuthenticator (Environment environment) {
        Authenticator<BasicCredentials, User> authenticator =  new BasicAuthenticator();
        final BasicCredentialAuthFilter<User> authFilter = new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(authenticator)
                .setRealm("Access Protected Ressource")
                .buildAuthFilter();
        environment.jersey().register(new AuthDynamicFeature(authFilter));
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }


    private void registerResources (Environment environment) {

        final HealthResource healthResource = new HealthResource();
        environment.jersey().register(healthResource);

        final FoodResource foodResource = new FoodResource();
        environment.jersey().register(foodResource);

        final RestaurantResource restaurantResource = new RestaurantResource();
        environment.jersey().register(restaurantResource);

        final OrderResource orderResource = new OrderResource();
        environment.jersey().register(orderResource);
    }
}
