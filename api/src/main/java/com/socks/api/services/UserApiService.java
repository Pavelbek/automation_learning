package com.socks.api.services;

import com.socks.api.models.User;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserApiService extends BaseApiService{

    public Response registerUser(User user){
        log.info("register user {}", user);
        return executePost("register", user);
    }

    public Response login(String userName, String password){
        log.info("log in with credentials user name: {} and password {}", userName, password);
        return executeGet("login", userName, password);
    }
}
