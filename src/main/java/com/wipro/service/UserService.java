package com.wipro.service;

import com.wipro.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
    User updateUser(User user);
    void deleteUser(int id);


}
