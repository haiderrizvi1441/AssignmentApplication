package com.hr.assignment_app_backend.repository;

import com.hr.assignment_app_backend.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    Optional<Assignment> getAssignmentByName(String name);
}
