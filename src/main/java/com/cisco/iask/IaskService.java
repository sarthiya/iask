package com.cisco.iask;

import com.cisco.iask.auth.LoginRequest;
import com.cisco.iask.dbresource.QuestionResource;
import com.cisco.iask.dbresource.UserResource;
import com.cisco.iask.entity.Question;
import com.cisco.iask.entity.User;
import com.cisco.iask.impl.AuthResourceImpl;
import com.cisco.iask.impl.IaskUserAuthenticator;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sun.jersey.api.container.filter.LoggingFilter;
import com.sun.jersey.api.core.ResourceConfig;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import lombok.extern.log4j.Log4j;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import com.cisco.iask.dao.*;

/**
 * Created by sarthiya on 16/04/16.
 */
@Log4j
public class IaskService extends Service<IaskServiceConfiguration>{

    public static void main(String[] args) throws Exception {

        new IaskService().run(args);

    }

    @Override
    public void initialize(Bootstrap bootstrap) {

        bootstrap.addBundle(hibernate);
    }

    private final HibernateBundle<IaskServiceConfiguration> hibernate =
            new HibernateBundle<IaskServiceConfiguration>(User.class, Question.class) {
        @Override
        public DatabaseConfiguration getDatabaseConfiguration(IaskServiceConfiguration configuration) {
            return configuration.getDatabaseConfiguration();
        }
    };


    public void run(IaskServiceConfiguration configuration, Environment environment) throws Exception {

        environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS,
                LoggingFilter.class.getName());
        environment.addResource(new AuthResourceImpl());
        environment.getObjectMapperFactory().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        //environment.addProvider(new IaskUserAuthenticator());
        final UserDAO dao = new UserDAO(hibernate.getSessionFactory());
        final QuestionDAO questionDAO = new QuestionDAO(hibernate.getSessionFactory());

        environment.addProvider(new BasicAuthProvider<LoginRequest>
                (new IaskUserAuthenticator(dao),
                "IASK LOGIN PAGE"));

        environment.addResource(new UserResource(dao));
        environment.addResource(new QuestionResource(questionDAO));


    }

}
