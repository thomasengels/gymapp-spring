package com.gym.user.domain.repository.custom;

import com.gym.user.domain.entity.User;

public interface UserRepositoryCustom {
    User getUserByEmail(String email);
}
