package com.hr.assignment_app_backend.service;


import com.hr.assignment_app_backend.entity.Role;
import com.hr.assignment_app_backend.entity.User;
import com.hr.assignment_app_backend.exception.CustomUserNotFoundException;
import com.hr.assignment_app_backend.model.UserLoginRequest;
import com.hr.assignment_app_backend.model.UserLoginResponse;
import com.hr.assignment_app_backend.model.UserRequest;
import com.hr.assignment_app_backend.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        log.info("Getting All Users");
        List<User> allUsers = userRepository.findAll();
        if(allUsers != null){

            return allUsers;
        }
        else {
            log.warn("No Users found");
            return Collections.emptyList();
        }
    }

    @Override
    public User getUserById(Long id) {
        log.info("Retrieving USER with ID:{}",id);
        User myUser = userRepository.findById(id).orElse(null);

        return myUser;
    }

    @Override
    public User getUserByUsername(String username) {
        log.info("Retrieving USER with username: {}",username );
        User myUser = userRepository.getUserByUsername(username).orElse(null);

        return myUser;
    }

    @Override
    public User createUser(UserRequest userRequest) {

        log.info("Creating User Profile");
        User myUser = User.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build();

        log.info("User Created");
        userRepository.save(myUser);
        log.info("User saved successfully");

        return myUser;
    }

    @Override
    public String deleteUserById(Long id) {
        User myUser = userRepository.findById(id).orElseThrow(() -> new CustomUserNotFoundException("User not found with given ID!!"));
        userRepository.delete(myUser);

        return "User Deleted Successfully";

    }

    @Override
    public String deleteUserByUsername(String username) {
        User myUser = userRepository.getUserByUsername(username).orElseThrow(() -> new CustomUserNotFoundException("User not found with given USERNAME"));
        userRepository.delete(myUser);

        return "User Deleted Successfully";
    }

    @Override
    public String deleteAllUsers() {
        log.warn("Deleting All Users");
        userRepository.deleteAll();

        return "All Users Deleted Successfully";
    }

    @Override
    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest) {
        User myUser = userRepository.getUserByUsername(userLoginRequest.getUsername()).orElse(null);
        if(myUser != null){
            String loginRequestPassword = userLoginRequest.getPassword();
            String storedUserPassword = myUser.getPassword();
            Boolean passwordMatch = (loginRequestPassword.equals(storedUserPassword));
            Boolean userRoleMatch = (userLoginRequest.getRole() == myUser.getRole());

            // If password is right,
            if(passwordMatch && !userRoleMatch){
                return new UserLoginResponse("Login Failed", false, myUser.getRole(), myUser.getId());
            }
            else if(passwordMatch){
                return new UserLoginResponse("Login Success", true,myUser.getRole(),myUser.getId());

            }

            else{
                return new UserLoginResponse("Password does not match", false, Role.STUDENT,999999999L);
            }
        }
        else{
            return new UserLoginResponse("User does not exist", false, Role.STUDENT, 999999999L);
        }



    }
}
