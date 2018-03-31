package com.gym.user.rest.controller.resources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
public class RegisterResource {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthday;

    public RegisterResource(String firstName, String lastName, String email, String password, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }


}
