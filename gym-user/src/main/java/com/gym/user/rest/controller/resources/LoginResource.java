package com.gym.user.rest.controller.resources;

import lombok.Getter;

@Getter
public class LoginResource {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
