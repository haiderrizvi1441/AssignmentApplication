package com.hr.assignment_app_backend.service;

import com.hr.assignment_app_backend.entity.Assignment;
import com.hr.assignment_app_backend.exception.CustomAssignmentNotFoundException;
import com.hr.assignment_app_backend.model.AssignmentRequest;
import com.hr.assignment_app_backend.model.AssignmentUpdateReviewerRequest;
import com.hr.assignment_app_backend.model.AssignmentUpdateStudentRequest;
import com.hr.assignment_app_backend.repository.AssignmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAllAssignments() {
        log.info("Retrieving all Assignments");
        List<Assignment> allAssignments = assignmentRepository.findAll();
        log.info("All Assignment retrieved");
        return allAssignments;
    }

    @Override
    public Assignment getAssignmentById(Long id) {
        Assignment myAssignment = assignmentRepository.findById(id).orElseThrow(() -> new CustomAssignmentNotFoundException("Assignment with given id not found"));
        return myAssignment;
    }

    @Override
    public Assignment getAssignmentByName(String name) {
        Assignment myAssignment = assignmentRepository.getAssignmentByName(name).orElseThrow(() -> new CustomAssignmentNotFoundException("Assignment with given name not found"));
        return myAssignment;
    }

    // Assignment Created By Student
    @Override
    public Assignment createAssignment(AssignmentRequest assignmentRequest) {
        log.info("Creating Assignment");
        Assignment myAssignment = Assignment.builder()
                .id(assignmentRequest.getId())
                .name(assignmentRequest.getName())
                .status(assignmentRequest.getStatus())
                .githubUrl(assignmentRequest.getGithubUrl())
                .branch(assignmentRequest.getBranch())
                .codeReviewVideoUrl(assignmentRequest.getCodeReviewVideoUrl())
                .user(assignmentRequest.getUser())
                .build();
        log.info("Assignment Created");

        assignmentRepository.save(myAssignment);
        log.info("Assignment Saved");

        return myAssignment;
    }

    // To Update new status for assignment
    @Override
    public Assignment updateAssignmentStatus(Long id, String newStatus) {

        log.info("Retrieving Assignment id:{}",id);
        Assignment toUpdateAssignment = assignmentRepository.findById(id).orElseThrow(()->new CustomAssignmentNotFoundException("Assignment by given id does not exist"));
        log.info("Assignment Retrieved Successfully");

        // Updating required properties
        toUpdateAssignment.setStatus(newStatus);
        log.info("Assignment Updated Successfully");

        // Saving update assignment
        assignmentRepository.save(toUpdateAssignment);

        return toUpdateAssignment;

    }

    @Override
    public Assignment studentUpdateAssignment(Long id, AssignmentUpdateStudentRequest updateStudentRequest) {
        log.info("Retrieving Assignment id:{}",id);
        Assignment toUpdateAssignment = assignmentRepository.findById(id).orElseThrow(()->new CustomAssignmentNotFoundException("Assignment by given id does not exist"));
        log.info("Assignment Retrieved Successfully");

        // updating required properties
        toUpdateAssignment.setStatus(updateStudentRequest.getStatus());
        toUpdateAssignment.setGithubUrl(updateStudentRequest.getGithubUrl());
        toUpdateAssignment.setBranch(updateStudentRequest.getBranch());
        toUpdateAssignment.setUser(updateStudentRequest.getUser());
        log.info("Assignment Updated Successfully");

        // Saving update assignment
        assignmentRepository.save(toUpdateAssignment);

        return toUpdateAssignment;
    }

    @Override
    public Assignment reviewerUpdateAssignment(Long id, AssignmentUpdateReviewerRequest updateReviewerRequest) {
        log.info("Retrieving Assignment id:{}",id);
        Assignment toUpdateAssignment = assignmentRepository.findById(id).orElseThrow(()->new CustomAssignmentNotFoundException("Assignment by given id does not exist"));
        log.info("Assignment Retrieved Successfully");

        // updating required properties
        toUpdateAssignment.setStatus(updateReviewerRequest.getStatus());
        toUpdateAssignment.setCodeReviewVideoUrl(updateReviewerRequest.getCodeReviewVideoUrl());
        toUpdateAssignment.setReviewerComment(updateReviewerRequest.getReviewerComment());
        toUpdateAssignment.setUser(updateReviewerRequest.getUser());
        log.info("Assignment Updated Successfully");

        // Saving updated assignment
        assignmentRepository.save(toUpdateAssignment);

        return toUpdateAssignment;
    }


    @Override
    public String deleteAssignmentById(Long id) {
        Assignment myAssignment = assignmentRepository.findById(id).orElseThrow(() -> new CustomAssignmentNotFoundException("Assignment with given ID not found"));
        assignmentRepository.delete(myAssignment);

        return "Assignment Deleted Successfully";
    }

    @Override
    public String deleteAssignmentByName(String name) {
        Assignment myAssignment = assignmentRepository.getAssignmentByName(name).orElseThrow(() -> new CustomAssignmentNotFoundException("Assignment with given NAME not found"));

        return "Assignment Deleted Successfully";
    }


}
