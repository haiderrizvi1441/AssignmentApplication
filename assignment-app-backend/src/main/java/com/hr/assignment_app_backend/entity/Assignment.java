package com.hr.assignment_app_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "assignments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String githubUrl;
    private String branch;
    private String codeReviewVideoUrl;

    @ManyToOne(optional = false, cascade = CascadeType.ALL) // optional is false as assignment cannot be created without user
    private User user;

}
