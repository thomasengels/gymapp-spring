package com.gym.user.rest.controller;

import com.gym.user.domain.entity.User;
import com.gym.user.rest.controller.resources.LoginResource;
import com.gym.user.rest.controller.resources.RegisterResource;
import com.gym.user.service.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody LoginResource loginResource) {
        User loggedInUser = authenticationService.login(loginResource);

        if(loggedInUser == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(loggedInUser);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody RegisterResource registerResource) {
        User registeredUser = authenticationService.register(registerResource);

        return ResponseEntity.ok(registeredUser);
    }
}
