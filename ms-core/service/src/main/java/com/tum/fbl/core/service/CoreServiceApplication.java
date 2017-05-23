package com.tum.fbl.core.service;

import com.tum.fbl.core.service.resources.HealthResource;
import io.dropwizard.Application;
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

        final HealthResource healthResource = new HealthResource();

        environment.jersey().register(healthResource);
    }
}
