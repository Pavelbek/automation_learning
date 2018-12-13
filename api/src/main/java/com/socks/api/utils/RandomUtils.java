package com.socks.api.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    public static String generateUserName(){
        return "UserName_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public static String generateUserFirstName(){
        return "FirstName_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public static String generateUserLastName(){
        return "LastName_" + RandomStringUtils.randomAlphanumeric(6);
    }

    public static String generateUserEmail(){
        return RandomStringUtils.randomAlphanumeric(6) + "@mail.com";
    }

    public static String generateUserPassword(){
        return RandomStringUtils.randomAlphanumeric(6);
    }
}
