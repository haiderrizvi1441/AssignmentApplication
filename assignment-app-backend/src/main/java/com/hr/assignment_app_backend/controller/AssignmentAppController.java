package com.hr.assignment_app_backend.controller;


import com.hr.assignment_app_backend.AssignmentAppBackendApplication;
import com.hr.assignment_app_backend.entity.Assignment;
import com.hr.assignment_app_backend.entity.User;
import com.hr.assignment_app_backend.model.*;
import com.hr.assignment_app_backend.service.AssignmentService;
import com.hr.assignment_app_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AssignmentAppController {

    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AssignmentAppBackendApplication assignmentAppBackendApplication;

    @GetMapping("/test")
    public String testing(){
        return "Assignment App Controller is working fine";
    }

    // USER
    //  Get All Users
    @GetMapping("/user/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    // Get Users By ID
    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User myUser = userService.getUserById(id);
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }
    // Get User by Username
    @GetMapping("/user/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        User myUser = userService.getUserByUsername(username);
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }

    // Create User
    @PostMapping("/user/createuser")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
        User myUser = userService.createUser(userRequest);
        return new ResponseEntity<>(myUser, HttpStatus.CREATED);
    }
    // Update User
    // Delete UserById
    @DeleteMapping("/user/deletebyid/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        String resultMessage = userService.deleteUserById(id);
        return new ResponseEntity<>(resultMessage, HttpStatus.ACCEPTED);
    }
    // Delete User By UserName
    @DeleteMapping("/user/deletebyname/{username}")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable String username){
        String resultMessage = userService.deleteUserByUsername(username);

        return new ResponseEntity<>(resultMessage, HttpStatus.ACCEPTED);
    }
    // Delete All Users
    @DeleteMapping("/user/deleteall")
    public ResponseEntity<String> deleteAllUsers(){
        String resultMessage = userService.deleteAllUsers();
        return new ResponseEntity<>(resultMessage, HttpStatus.ACCEPTED);
    }

    // User Login
    @PostMapping("/user/login")
    public ResponseEntity<UserLoginResponse> userLogin(@RequestBody UserLoginRequest userLoginRequest){
        UserLoginResponse userLoginResponse = userService.loginUser(userLoginRequest);
        return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
    }

    // ASSIGNMENT

    // Get All Assignments
    @GetMapping("/assignment/assignments")
    public ResponseEntity<List<Assignment>> getAllAssignment(){
        List<Assignment> allAssignments = assignmentService.getAllAssignments();

        return new ResponseEntity<>(allAssignments,HttpStatus.OK);
    }

    // Get Assignment By Id
    @GetMapping("/assignment/id/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id){
        Assignment myAssignment = assignmentService.getAssignmentById(id);

        return new ResponseEntity<>(myAssignment, HttpStatus.OK);
    }

    // Get Assignment By Name
    @GetMapping("/assignment/name/{name}")
    public ResponseEntity<Assignment> getAssignmentByName(@PathVariable String name){
        Assignment myAssignment = assignmentService.getAssignmentByName(name);

        return new ResponseEntity<>(myAssignment, HttpStatus.OK);
    }
    // Create Assignment
    @PostMapping("/assignment/createassignment")
    public ResponseEntity<Assignment> createAssignment(@RequestBody AssignmentRequest assignmentRequest){
        Assignment myAssignment = assignmentService.createAssignment(assignmentRequest);

        return new ResponseEntity<>(myAssignment, HttpStatus.CREATED);
    }

    // Update assignment Status
    @PutMapping("/assignment/updatestatus/{id}")
    public ResponseEntity<Assignment> updateAssignmentStatus(@PathVariable Long id, @RequestBody String newStatus){
        Assignment updatedAssignment = assignmentService.updateAssignmentStatus(id, newStatus);

        return new ResponseEntity<>(updatedAssignment, HttpStatus.ACCEPTED);
    }

    // Assignment Update By Student
    @PutMapping("/assignment/studentupdateassignment/{id}")
    public ResponseEntity<Assignment> updateAssignmentStudent(@PathVariable Long id, @RequestBody AssignmentUpdateStudentRequest studentUpdateRequest){
        Assignment updatedAssignment = assignmentService.studentUpdateAssignment(id,studentUpdateRequest);

        return new ResponseEntity<>(updatedAssignment, HttpStatus.ACCEPTED);
    }

    // Assignment Update By Reviewer
    @PutMapping("/assignment/reviewerupdateassignment/{id}")
    public ResponseEntity<Assignment> updateAssignmentReviewer(@PathVariable Long id, @RequestBody AssignmentUpdateReviewerRequest reviewerUpdateRequest){
        Assignment updatedAssignment = assignmentService.reviewerUpdateAssignment(id, reviewerUpdateRequest);

        return new ResponseEntity<>(updatedAssignment, HttpStatus.ACCEPTED);


    }

    // Delete Assignment By Id
    @DeleteMapping("/assignment/deletebyid/{id}")
    public ResponseEntity<String> deleteAssignmentById(@PathVariable Long id){
        String resultMessage = assignmentService.deleteAssignmentById(id);

        return new ResponseEntity<>(resultMessage, HttpStatus.ACCEPTED);
    }
    // Delete Assignment By Name
    @DeleteMapping("/assignment/deletebyname/{name}")
    public ResponseEntity<String> deleteAssignmentByName(@PathVariable String name){
        String resultMessage = assignmentService.deleteAssignmentByName(name);

        return new ResponseEntity<>(resultMessage, HttpStatus.ACCEPTED);
    }

}
