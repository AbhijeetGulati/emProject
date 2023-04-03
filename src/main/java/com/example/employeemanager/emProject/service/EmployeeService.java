package com.example.employeemanager.emProject.service;

import com.example.employeemanager.emProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //declare all the methods that were declared in the DAO interface

    public List<Employee> findAll();



    Employee findById(int theId);


    Employee save(Employee theEmployee);


    void deleteById(int theId);

}
