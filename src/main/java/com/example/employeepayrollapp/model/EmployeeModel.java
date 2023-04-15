package com.example.employeepayrollapp.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String empName;
    private String empProfilePic;
    private String empGender;

    @ElementCollection
    @CollectionTable(name = "emp_department", joinColumns = @JoinColumn(name = "empId"))
    private List<String> empDepartment;

    private String empSalary;
    private Date startDate;
    private String note;

}