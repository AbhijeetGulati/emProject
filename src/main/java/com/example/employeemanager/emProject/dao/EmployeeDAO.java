package com.example.employeemanager.emProject.dao;

import com.example.employeemanager.emProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //declare a method to get a list of all employees
    List<Employee> findAll();

    //finding employee based on id
    Employee findById(int theId);

    //adding an employee
    Employee save(Employee theEmployee);

    //delete an employee based on id
    void deleteById(int theId);
}
