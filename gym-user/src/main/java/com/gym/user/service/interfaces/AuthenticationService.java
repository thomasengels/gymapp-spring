package com.gym.user.service.interfaces;

import com.gym.user.domain.entity.User;
import com.gym.user.rest.controller.resources.LoginResource;
import com.gym.user.rest.controller.resources.RegisterResource;

public interface AuthenticationService {
    User login(LoginResource loginResource);
    User register(RegisterResource registerResource);
}
