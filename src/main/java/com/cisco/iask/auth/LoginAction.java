package com.cisco.iask.auth;

import com.google.inject.Inject;

/**
 * Created by sarthiya on 17/04/16.
 */
public class LoginAction {

    private LoginRequest loginRequest;
    private LoginResponse loginResponse;



    public LoginAction(LoginResponse loginResponse){
        this.loginResponse= loginResponse;
        this.loginResponse.setValidUser(false);

    }

    public LoginResponse invoke(){
        if(loginRequest.getPassword().equals("password")){
           loginResponse.setUsername(loginRequest.getUsername());
            loginResponse.setValidUser(true);
        }
        return loginResponse;
    }

    public LoginAction withLoginRequest(LoginRequest loginReguest){
        this.loginRequest= loginReguest;
        return this;
    }
}
