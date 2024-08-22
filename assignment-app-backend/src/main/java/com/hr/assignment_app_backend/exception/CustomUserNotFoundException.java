package com.hr.assignment_app_backend.exception;


public class CustomUserNotFoundException extends RuntimeException{

    public CustomUserNotFoundException(String message){
        super(message);
    }
}
