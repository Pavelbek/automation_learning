package com.socks.api.utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    private static Faker faker = new Faker();


    public static String generateUserName(){
        return faker.name().nameWithMiddle();
    }

    public static String generateUserFirstName(){
        return faker.name().firstName();
    }

    public static String generateUserLastName(){
        return faker.name().lastName();
    }

    public static String generateUserEmail(){ return faker.internet().emailAddress(); }

    public static String generateUserPassword(){
        return faker.internet().password();
    }
}
