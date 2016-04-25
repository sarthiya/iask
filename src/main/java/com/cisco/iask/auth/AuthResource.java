package com.cisco.iask.auth;

import com.yammer.dropwizard.auth.basic.BasicCredentials;

/**
 * Created by sarthiya on 16/04/16.
 */
public interface AuthResource {

    public LoginResponse authenticateUser(LoginRequest request);
    public LoginResponse tempresponse();

}
