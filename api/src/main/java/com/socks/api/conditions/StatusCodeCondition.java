package com.socks.api.conditions;

import com.socks.api.enums.StatusCode;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
public class StatusCodeCondition implements Condition{

    private StatusCode statusCode;

    @Override
    public void check(Response response) {
        assertThat(response.getStatusCode(), equalTo(statusCode.getValue()));
    }

    @Override
    public String toString() {
        return "status code " + statusCode;
    }
}
