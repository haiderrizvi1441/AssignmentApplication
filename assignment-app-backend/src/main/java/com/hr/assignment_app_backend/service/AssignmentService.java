package com.hr.assignment_app_backend.service;

import com.hr.assignment_app_backend.entity.Assignment;
import com.hr.assignment_app_backend.model.AssignmentRequest;

import java.util.List;

public interface AssignmentService {

    // Get All Assignments
    List<Assignment> getAllAssignments();
    // Get Assignment By Id
    Assignment getAssignmentById(Long id);
    // Get Assignment By Name
    Assignment getAssignmentByName(String name);
    // Create Assignment
    Assignment createAssignment(AssignmentRequest assignmentRequest);
    // Update Assignment
    // Delete Assignment By Id
    String deleteAssignmentById(Long id);
    // Delete Assignment By Name
    String deleteAssignmentByName(String name);
}
