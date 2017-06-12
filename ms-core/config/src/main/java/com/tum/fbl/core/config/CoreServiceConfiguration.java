package com.tum.fbl.core.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Created by patrickmelchner on 23.05.17.
 */
public class CoreServiceConfiguration extends Configuration {

    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @JsonProperty("database")
    private DataSourceFactory databaseConfiguration;

    public SwaggerBundleConfiguration getSwaggerBundleConfiguration () {
        return this.swaggerBundleConfiguration;
    }

    public DataSourceFactory getDatabaseConfiguration () {
        return this.databaseConfiguration;
    }
}
