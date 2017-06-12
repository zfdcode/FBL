package com.tum.fbl.core.persistence;

import com.tum.fbl.core.config.CoreServiceConfiguration;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by patrickmelchner on 12.06.17.
 */
public class ConnectionFactory {

    private final DBI dbi;

    public ConnectionFactory(CoreServiceConfiguration configuration, Environment environment) {
        this.dbi = this.connectToDatabase(configuration, environment);
    }

    public DBI getConnection() {
        return this.dbi;
    }

    private DBI connectToDatabase(CoreServiceConfiguration configuration, Environment environment) {
        DBIFactory factory = new DBIFactory();
        return factory.build(environment, configuration.getDatabaseConfiguration(), "database");
    }
}
