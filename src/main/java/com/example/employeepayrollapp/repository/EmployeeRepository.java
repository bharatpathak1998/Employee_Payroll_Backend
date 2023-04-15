package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}