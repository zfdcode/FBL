package com.tum.fbl.core.service;

import com.tum.fbl.core.config.CoreServiceConfiguration;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.service.auth.BasicAuthenticator;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.resources.MealResource;
import com.tum.fbl.core.service.resources.HealthResource;
import com.tum.fbl.core.service.resources.OrderResource;
import com.tum.fbl.core.service.resources.RestaurantResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
                return configuration.getSwaggerBundleConfiguration();
            }
        });

        bootstrap.addBundle(new MigrationsBundle<CoreServiceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(CoreServiceConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });

        bootstrap.addBundle(new MultiPartBundle());
    }

    @Override
    public void run(CoreServiceConfiguration configuration,
                    Environment environment) {

        configureCors(environment);

        registerAuthenticator(environment);

        registerResources(environment);

        final ConnectionFactory dbiFactory = new ConnectionFactory(configuration, environment);

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

        final MealResource mealResource = new MealResource();
        environment.jersey().register(mealResource);

        final RestaurantResource restaurantResource = new RestaurantResource();
        environment.jersey().register(restaurantResource);

        final OrderResource orderResource = new OrderResource();
        environment.jersey().register(orderResource);
    }

    private void configureCors(Environment environment) {
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }
}
