package com.example.employeepayrollapp.exception;

public class EmployeeNotFoundException extends RuntimeException {

    String message;
    long id;

    public EmployeeNotFoundException(String message, long id) {
        super(String.format("%s not found with Id : %s", message, id));
        this.message = message;
        this.id = id;
    }
}