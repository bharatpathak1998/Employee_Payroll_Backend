package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.exception.EmployeeNotFoundException;
import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    // method to save the employee in the database :-
    public void save(EmployeeDto employeeDto) {
        EmployeeModel dtoToEntity = modelMapper.map(employeeDto, EmployeeModel.class);
        employeeRepository.save(dtoToEntity);
    }

    // method to get All the employees from the database :-
    public List<EmployeeDto> getAll() {
        List<EmployeeModel> allEmployeeList = employeeRepository.findAll();
        return allEmployeeList.stream().map(i ->
                        modelMapper.map(i, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    // method to get the particular employee from the database :-
    public EmployeeModel getById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("employee", id));
    }

    // method to update particular employee from the database :-
    public void updateById(long id, EmployeeDto employeeDto) {
        EmployeeModel employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("employee", id));
        employeeDto.setEmpId(employee.getEmpId());
        EmployeeModel dtoToEntity = modelMapper.map(employeeDto, EmployeeModel.class);
        employeeRepository.save(dtoToEntity);
    }

    // method to delete particular employee from the database :-
    public void deleteById(long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("employee", id));
        employeeRepository.delete(employeeModel);
    }
}