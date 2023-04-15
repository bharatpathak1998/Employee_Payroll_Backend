package com.example.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmployeeDto {
    private long empId;

    @NotEmpty(message = "Name should not be empty!")
    private String empName;
    private String empProfilePic;

    @NotEmpty(message = "Gender should not be empty!")
    private String empGender;
    private List<String> empDepartment;
    private String empSalary;
    private Date startDate;

    @NotEmpty(message = "Note should not be empty!")
    private String note;
}