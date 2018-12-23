package com.socks.api.conditions;

import com.socks.api.enums.StatusCode;

public class Conditions {

    public static StatusCodeCondition statusCode(StatusCode code){
        return new StatusCodeCondition(code);
    }
}
