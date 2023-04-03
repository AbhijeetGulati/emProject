package com.example.employeemanager.emProject.service;

import com.example.employeemanager.emProject.dao.EmployeeJPARepository;
import com.example.employeemanager.emProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    //inject EmployeeDAO because we are using its method

    private EmployeeJPARepository employeeJPARepository;

    //constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeJPARepository eJPARepo){//constructor injection
        employeeJPARepository=eJPARepo;
    }
    //just delegate the calls to DAO
    @Override
    public List<Employee> findAll() {
        //delegating calls to DAO
        return employeeJPARepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeJPARepository.findById(theId);//Optional is new feature in java
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            //we didnt find the employee
            throw new RuntimeException("Employee not found with id :"+theId);
        }
        return theEmployee;
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeJPARepository.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {
        //just call method defined in dao layer
        employeeJPARepository.deleteById(theId);
        //project on git
    }
}
