package com.socks.tests.brutal;

import com.socks.api.models.RegisterUserResponse;
import com.socks.api.models.User;
import com.socks.api.services.UserApiService;
import com.socks.api.utils.ModelsGererator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

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

        Response response = userApiService.registerUser(user);
        RegisterUserResponse registerUserResponse = response.getBody().as(RegisterUserResponse.class);

        assertThat("Id should be not empty, but was.", registerUserResponse.getId().isEmpty(), equalTo(false));
    }

    @Test
    public void testCanNotRegisterUserWithInvalidEmail(){

        User user = ModelsGererator.getUserModel();
        user.setEmail("");

        Response response = userApiService.registerUser(user);

        assertThat("Actual status code is: " + response.getStatusCode() + ", but expected is: 400", response.getStatusCode(), equalTo(400));
    }

    @Test
    public void testCanNotRegisterUserWithInvalidPassword(){

        User user = ModelsGererator.getUserModel();
        user.setPassword("");

        Response response = userApiService.registerUser(user);

        assertThat("Actual status code is: " + response.getStatusCode() + ", but expected is: 400", response.getStatusCode(), equalTo(400));
    }

    @Test
    public void testUserCanLogInWithValidCredentials(){

        User user = ModelsGererator.getUserModel();

        Response response = userApiService.registerUser(user);

        assertThat("Actual status code is: " + response.getStatusCode() + ", but expected is: 200", response.getStatusCode(), equalTo(200));

        Response loginResponse = userApiService.login(user.getUsername(), user.getPassword());

        assertThat("Actual status code is: " + loginResponse.getStatusCode() + ", but expected is: 200", loginResponse.getStatusCode(), equalTo(200));
    }

    @Test
    public void testUserCanNotLogInWithInvalidPassword(){

        User user = ModelsGererator.getUserModel();

        Response response = userApiService.registerUser(user);

        assertThat("Actual status code is: " + response.getStatusCode() + ", but expected is: 200", response.getStatusCode(), equalTo(200));

        Response loginResponse = userApiService.login(user.getUsername(), "");

        assertThat("Actual status code is: " + loginResponse.getStatusCode() + ", but expected is: 401", loginResponse.getStatusCode(), equalTo(401));

    }

    @Test
    public void testUserCanNotLogInWithInvalidUserName(){

        User user = ModelsGererator.getUserModel();

        Response response = userApiService.registerUser(user);

        assertThat("Actual status code is: " + response.getStatusCode() + ", but expected is: 200", response.getStatusCode(), equalTo(200));

        Response loginResponse = userApiService.login("", user.getPassword());

        assertThat("Actual status code is: " + loginResponse.getStatusCode() + ", but expected is: 401", loginResponse.getStatusCode(), equalTo(401));

    }
}
