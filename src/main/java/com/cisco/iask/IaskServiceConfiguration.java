package com.cisco.iask;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.client.JerseyClientConfiguration;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by sarthiya on 16/04/16.
 */
@Data
public class IaskServiceConfiguration extends Configuration{

    @NotNull
    @Valid
    @JsonProperty
    private DatabaseConfiguration databaseConfiguration;

    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    @NotNull
    @Valid
    private JerseyClientConfiguration jerseyClientConfiguration;
}
