package com.example.Report.Repo;

import com.example.Report.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface Repository extends JpaRepository<Employee, Long> {
    @Query(value = "select employee_id, first_name, " +
            "last_name, email, hire_date, salary from hr.employees where salary > 3000",nativeQuery = true)
    List<Employee> FirstReport();
}
