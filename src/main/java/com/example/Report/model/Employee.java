package com.example.Report.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
//@Table(name="Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name ="EMPLOYEE_ID")
    private long EMPLOYEE_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String EMAIL;
    private Date HIRE_DATE;
    private String SALARY;
}
