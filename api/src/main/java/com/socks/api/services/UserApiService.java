package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.models.User;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserApiService extends BaseApiService{

    @Step
    public AssertableResponse registerUser(User user){
        log.info("register user {}", user);
        return new AssertableResponse(executePost("register", user));
    }

    public AssertableResponse login(String userName, String password){
        log.info("log in with credentials user name: {} and password {}", userName, password);
        return new AssertableResponse(executeGet("login", userName, password));
    }
}
