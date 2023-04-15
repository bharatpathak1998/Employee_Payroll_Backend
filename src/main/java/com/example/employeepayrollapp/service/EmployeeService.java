package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeDto employeeDto);

    List<EmployeeDto> getAll();

    EmployeeModel getById(long id);

    void updateById(long id, EmployeeDto employeeDto);

    void deleteById(long id);
}