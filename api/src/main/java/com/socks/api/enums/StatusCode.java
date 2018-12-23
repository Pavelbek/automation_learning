package com.socks.api.enums;

public enum StatusCode {
    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized");

    private final int value;
    private final String reasonPhrase;

    StatusCode(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }
}
