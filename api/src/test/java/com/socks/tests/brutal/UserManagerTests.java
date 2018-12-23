package com.socks.tests.brutal;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.enums.StatusCode;
import com.socks.api.models.RegisterUserResponse;
import com.socks.api.models.User;
import com.socks.api.services.UserApiService;
import com.socks.api.utils.ModelsGererator;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserManagerTests {

    private UserApiService userApiService;

    public UserManagerTests(){
        userApiService = new UserApiService();
    }

    @Test
    public void testCanRegisterUserWithValidCredentials(){

        User user = ModelsGererator.getUserModel();

        AssertableResponse assertableResponse = userApiService.registerUser(user);

        assertableResponse.shouldHave(statusCode(StatusCode.OK));

        assertRegisteredUserIdIsNotEmpty(assertableResponse);
    }

    @Test
    public void testCanNotRegisterUserWithInvalidEmail(){

        User user = ModelsGererator.getUserModel();
        user.setEmail("");

        AssertableResponse response = userApiService.registerUser(user);

        response.shouldHave(statusCode(StatusCode.BAD_REQUEST));
    }

    @Test
    public void testCanNotRegisterUserWithInvalidPassword(){

        User user = ModelsGererator.getUserModel();
        user.setPassword("");

        AssertableResponse response = userApiService.registerUser(user);

        response.shouldHave(statusCode(StatusCode.BAD_REQUEST));
    }

    @Test
    public void testUserCanLogInWithValidCredentials(){

        User user = ModelsGererator.getUserModel();

        userApiService.registerUser(user);

        AssertableResponse loginResponse = userApiService.login(user.getUsername(), user.getPassword());

        loginResponse.shouldHave(statusCode(StatusCode.OK));
    }

    @Test
    public void testUserCanNotLogInWithInvalidPassword(){

        User user = ModelsGererator.getUserModel();

        userApiService.registerUser(user);

        AssertableResponse loginResponse = userApiService.login(user.getUsername(), "");

        loginResponse.shouldHave(statusCode(StatusCode.UNAUTHORIZED));
    }

    @Test
    public void testUserCanNotLogInWithInvalidUserName(){

        User user = ModelsGererator.getUserModel();

        userApiService.registerUser(user);

        AssertableResponse loginResponse = userApiService.login("", user.getPassword());

        loginResponse.shouldHave(statusCode(StatusCode.UNAUTHORIZED));
    }

    @Step("Checking that id in registered user response is not empty")
    private void assertRegisteredUserIdIsNotEmpty(AssertableResponse response){
        RegisterUserResponse registerUserResponse = response.getBody(RegisterUserResponse.class);
        assertThat("Id should be not empty, but was.", registerUserResponse.getId().isEmpty(), equalTo(false));
    }
}
