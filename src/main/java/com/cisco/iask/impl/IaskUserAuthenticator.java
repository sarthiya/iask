package com.cisco.iask.impl;

import com.cisco.iask.auth.LoginRequest;
import com.cisco.iask.dao.UserDAO;
import com.cisco.iask.entity.User;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import lombok.extern.log4j.Log4j;

import java.util.List;


/**
 * Created by sarthiya on 17/04/16.
 */


@Log4j
public class IaskUserAuthenticator implements Authenticator<BasicCredentials, LoginRequest> {

    /**
     * The DAO object to manipulate employees.
     */
    private UserDAO userDAO;
    /**
     * Constructor.
     *
     * @param userDAO DAO object to manipulate employees.
     */

    public IaskUserAuthenticator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Optional<LoginRequest> authenticate(BasicCredentials credentials) throws AuthenticationException {

        List<User> user = userDAO.findByUserName(credentials.getUsername());
        if(user == null || user.isEmpty())
        {
            return Optional.absent();
        }
        else if(credentials.getPassword().equals(user.get(0).getPassword()))
        {
            return Optional.of(new LoginRequest());
        }

        return Optional.absent();
    }
}