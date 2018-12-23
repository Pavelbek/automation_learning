package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    private final Response response;

    @Step("Api response should be {condition}")
    public AssertableResponse shouldHave(Condition condition){
        log.info("check that " + condition);
        condition.check(response);
        return this;
    }

    @Step("Taking serialized body as {clazz}")
    public <T> T getBody(Class<T> clazz){
        return response.getBody().as(clazz);
    }
}
