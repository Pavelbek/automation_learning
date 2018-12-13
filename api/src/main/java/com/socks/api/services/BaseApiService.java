package com.socks.api.services;

import com.socks.api.utils.ApiPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApiService {

    public BaseApiService(){
        RestAssured.baseURI = ApiPropertiesReader.getProperty("baseUrl");
        //RestAssured.authentication = basic(ApiPropertiesReader.getProperty("baseUserName"), ApiPropertiesReader.getProperty("baseUserPassword"));
    }

    public RequestSpecification setUp(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    protected Response executeGet(String path, String userName, String password){
        return setUp()
                .auth()
                .preemptive()
                .basic(userName, password)
                .when()
                .get(path)
                .andReturn();
    }

    public Response executePost(String path, Object body){
        return  setUp()
                .body(body)
                .post(path)
                .andReturn();
    }
}
