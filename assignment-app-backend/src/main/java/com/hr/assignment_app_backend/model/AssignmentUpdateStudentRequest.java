package com.hr.assignment_app_backend.model;

import com.hr.assignment_app_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AssignmentUpdateStudentRequest {

    private Long id;
    private String status;
    private String githubUrl;
    private String branch;
    private User user;
}
