package com.hr.assignment_app_backend.model;

import com.hr.assignment_app_backend.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignmentRequest {

    private Long id;
    private String name;
    private String status;
    private String githubUrl;
    private String branch;
    private String codeReviewVideoUrl;

//    @ManyToOne(optional = false) // optional is false as assignment cannot be created without user
    private User user;
}
