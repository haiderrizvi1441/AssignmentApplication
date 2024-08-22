package com.hr.assignment_app_backend.model;

import com.hr.assignment_app_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse {

    String message;
    Boolean Status;
    Role role;
    Long id;

}
