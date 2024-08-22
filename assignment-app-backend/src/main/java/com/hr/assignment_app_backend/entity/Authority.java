//package com.hr.assignment_app_backend.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class Authority implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String authority;
//
//    @ManyToOne(optional = false)
//    private User user;
//
//    public Authority(String authority){
//        this.authority= authority;
//    }
//
//
//}
