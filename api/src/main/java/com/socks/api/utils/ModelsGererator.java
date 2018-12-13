package com.socks.api.utils;

import com.socks.api.models.User;

public class ModelsGererator {

    public static User getUserModel(){
        return new  User()
                .setUsername(RandomUtils.generateUserName())
                .setFirstName(RandomUtils.generateUserFirstName())
                .setLastName(RandomUtils.generateUserLastName())
                .setEmail(RandomUtils.generateUserEmail())
                .setPassword(RandomUtils.generateUserPassword());
    }
}
