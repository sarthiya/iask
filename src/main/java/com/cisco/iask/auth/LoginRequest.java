package com.cisco.iask.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by sarthiya on 16/04/16.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
