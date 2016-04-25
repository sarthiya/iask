package com.cisco.iask.impl;

import com.cisco.iask.auth.AuthResource;
import com.cisco.iask.auth.LoginAction;
import com.cisco.iask.auth.LoginRequest;
import com.cisco.iask.auth.LoginResponse;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yammer.dropwizard.auth.Auth;
import com.yammer.dropwizard.auth.basic.BasicCredentials;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.metrics.annotation.Timed;
import lombok.extern.log4j.Log4j;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by sarthiya on 17/04/16.
 */

@Log4j
@Path("/auth")
public class AuthResourceImpl implements AuthResource {
    @Context
    private UriInfo uriInfo;
    /*private final Provider<LoginAction> loginActionProvider;

    @Inject
    public AuthResourceImpl(Provider<LoginAction> loginActionProvider){
        this.loginActionProvider = loginActionProvider;
    }*/

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    public LoginResponse authenticateUser(@Auth LoginRequest request) {
        //return loginActionProvider.get().withLoginRequest(request).invoke();
        LoginResponse lr = new LoginResponse();
        lr.setUsername("BH");
        lr.setValidUser(true);
        return lr;
    }


    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse tempresponse(){
        LoginResponse lr = new LoginResponse();
        lr.setUsername("BHN");
        lr.setValidUser(true);
        return lr;
    }

}
