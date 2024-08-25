package com.hr.assignment_app_backend.model;

import com.hr.assignment_app_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentUpdateReviewerRequest {

    private Long id;
    private String status;
    private String codeReviewVideoUrl;
    private String reviewerComment;
    private User user;
}
