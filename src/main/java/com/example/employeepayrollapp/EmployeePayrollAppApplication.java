package com.example.employeepayrollapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeePayrollAppApplication {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
        System.out.println("********* Welcome To Employee Payroll App *********");
    }
}