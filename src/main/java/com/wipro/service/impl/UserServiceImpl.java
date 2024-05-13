package com.wipro.service.impl;

import com.wipro.model.User;
import com.wipro.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void createUser(User user) {
        log.info("Creating User in Repository : {} " , user);
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Get all users..");
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User toBeDeleted = entityManager.find(User.class,id);
        if(toBeDeleted != null)
            entityManager.remove(toBeDeleted);
        else
            throw new RuntimeException("User Id not found");
    }
}
