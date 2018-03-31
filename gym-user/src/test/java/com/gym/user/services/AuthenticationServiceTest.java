package com.gym.user.services;

import com.gym.user.domain.entity.User;
import com.gym.user.domain.repository.mysql.UserRepository;
import com.gym.user.rest.controller.resources.RegisterResource;
import com.gym.user.service.impl.AuthenticationServiceImpl;
import com.gym.user.service.interfaces.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    private AuthenticationService authenticationService;

    @Before
    public void setup(){
        this.authenticationService = new AuthenticationServiceImpl(userRepository, modelMapper, passwordEncoder);
    }

    @Test
    public void registerValidUserTest(){
        RegisterResource registerResource = new RegisterResource(
                "Thomas","Engels","test@test.com","test",new Date()
        );

        User user = authenticationService.register(registerResource);

        verify(userRepository).save(user);
    }
}
