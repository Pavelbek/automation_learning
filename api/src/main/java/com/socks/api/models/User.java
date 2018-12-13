package com.socks.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;
}