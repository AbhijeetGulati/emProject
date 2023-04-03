package com.example.employeemanager.emProject.dao;

import com.example.employeemanager.emProject.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJPARepository extends JpaRepository<Employee,Integer> {
    //we just have to specify Entity type and Primary key type
    //now we can use all CRUD methods as before

}
