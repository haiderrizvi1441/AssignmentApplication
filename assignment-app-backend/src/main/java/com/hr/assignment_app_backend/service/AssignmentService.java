package com.hr.assignment_app_backend.service;

import com.hr.assignment_app_backend.entity.Assignment;
import com.hr.assignment_app_backend.model.AssignmentRequest;
import com.hr.assignment_app_backend.model.AssignmentUpdateReviewerRequest;
import com.hr.assignment_app_backend.model.AssignmentUpdateStudentRequest;
import jakarta.transaction.Status;
import org.springframework.web.bind.annotation.PathVariable;

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
     // Change Assignment Status
    Assignment updateAssignmentStatus(Long id, String newStatus);
    // Student Assignment Update
    Assignment studentUpdateAssignment(Long id, AssignmentUpdateStudentRequest updateStudentRequest);
    // Reviewer Assignment Status
    Assignment reviewerUpdateAssignment(Long id, AssignmentUpdateReviewerRequest updateReviewerRequest);


    // Delete Assignment By Id
    String deleteAssignmentById(Long id);
    // Delete Assignment By Name
    String deleteAssignmentByName(String name);
}
