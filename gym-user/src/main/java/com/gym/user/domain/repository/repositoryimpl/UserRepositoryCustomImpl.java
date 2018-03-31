package com.gym.user.domain.repository.repositoryimpl;

import com.gym.user.domain.entity.User;
import com.gym.user.domain.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public User getUserByEmail(String email) {
        Query selectUserByEmailQuery = entityManager.createQuery("SELECT u FROM User u where u.email = :email", User.class);

        return (User) selectUserByEmailQuery.getSingleResult();
    }
}
