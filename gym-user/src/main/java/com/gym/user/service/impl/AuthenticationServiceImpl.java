package com.gym.user.service.impl;

import com.gym.user.domain.entity.User;
import com.gym.user.domain.repository.mysql.UserRepository;
import com.gym.user.rest.controller.resources.LoginResource;
import com.gym.user.rest.controller.resources.RegisterResource;
import com.gym.user.service.interfaces.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    private UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(LoginResource loginResource) {
        User user = userRepository.getUserByEmail(loginResource.getEmail());

        String encodedPassword = passwordEncoder.encode(loginResource.getPassword());

        boolean passwordMatch = passwordEncoder.matches(encodedPassword, user.getPassword());

        return passwordMatch ? user : null;
    }

    @Override
    public User register(RegisterResource registerResource) {
        User user = modelMapper.map(registerResource, User.class);

        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        user.encodePassword(encryptedPassword);

        return userRepository.save(user);
    }


}
