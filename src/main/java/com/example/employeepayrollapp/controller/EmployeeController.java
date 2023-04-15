package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDto;
import com.example.employeepayrollapp.model.EmployeeModel;
import com.example.employeepayrollapp.service.EmployeeService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee_service")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> add(@Valid @RequestBody EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
        return new ResponseEntity<>(Map.of("message", "User Registration Successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/retrieve")
    public List<EmployeeDto> getAllUser() {
        return employeeService.getAll();
    }

    @GetMapping("/get/{id}")
    public EmployeeModel getUserById(@PathVariable long id) {
        return employeeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable long id, @Valid @RequestBody EmployeeDto employeeDto) {
        employeeService.updateById(id, employeeDto);
        return new ResponseEntity<>(Map.of("message","User Updated Successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(Map.of("message","User Deleted Successfully"), HttpStatus.OK);
    }
}