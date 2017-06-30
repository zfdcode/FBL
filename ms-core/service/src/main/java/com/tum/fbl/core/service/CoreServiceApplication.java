package com.tum.fbl.core.service;

import com.tum.fbl.core.config.CoreServiceConfiguration;
import com.tum.fbl.core.persistence.ConnectionFactory;
import com.tum.fbl.core.service.auth.BasicAuthenticator;
import com.tum.fbl.core.service.auth.User;
import com.tum.fbl.core.service.resources.*;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
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

        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(CoreServiceConfiguration configuration,
                    Environment environment) {

        final ConnectionFactory connectionFactory = new ConnectionFactory(configuration, environment);

        configureCors(environment);

        registerAuthenticator(environment);

        registerResources(environment, connectionFactory);

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


    private void registerResources (Environment environment, ConnectionFactory connectionFactory) {

        final HealthDataResource healthDataResource = new HealthDataResource(connectionFactory);
        environment.jersey().register(healthDataResource);

        final MealResource mealResource = new MealResource(connectionFactory);
        environment.jersey().register(mealResource);

        final RestaurantResource restaurantResource = new RestaurantResource(connectionFactory);
        environment.jersey().register(restaurantResource);

        final OrderResource orderResource = new OrderResource(connectionFactory);
        environment.jersey().register(orderResource);

        final IngredientResource ingredientResource = new IngredientResource(connectionFactory);
        environment.jersey().register(ingredientResource);

        final RatingResource ratingResource = new RatingResource(connectionFactory);
        environment.jersey().register(ratingResource);

        final SpecialNeedResource specialNeedResource = new SpecialNeedResource(connectionFactory);
        environment.jersey().register(specialNeedResource);

        final UserResource userResource = new UserResource(connectionFactory);
        environment.jersey().register(userResource);
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
