package com.cisco.iask.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by sarthiya on 16/04/16.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse implements Serializable{


    private String username;


    private boolean isValidUser;
}
