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
public class UserLoginRequest {

    private String username;
    private String password;
    private Role role;
}
