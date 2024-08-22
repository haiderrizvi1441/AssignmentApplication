package com.hr.assignment_app_backend.service;

import com.hr.assignment_app_backend.entity.User;
import com.hr.assignment_app_backend.model.UserLoginRequest;
import com.hr.assignment_app_backend.model.UserLoginResponse;
import com.hr.assignment_app_backend.model.UserRequest;

import java.util.List;

public interface UserService {


    // Get All users
    List<User> getAllUsers();
    // Get Users By ID
    User getUserById(Long id);
    // Get User by Username
    User getUserByUsername(String username);
    // Create User
    User createUser(UserRequest userRequest);
    // Update User
    // Delete UserById
    String deleteUserById(Long id);
    // Delete User By Username
    String deleteUserByUsername(String username);
    // Delete All Users
    String deleteAllUsers();

    UserLoginResponse loginUser(UserLoginRequest userLoginRequest);
}
