package com.example.employeemanager.emProject.service;

import com.example.employeemanager.emProject.dao.EmployeeDAO;
import com.example.employeemanager.emProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    //inject EmployeeDAO because we are using its method

    private EmployeeDAO employeeDAO;

    //constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO edao){//constructor injection
        employeeDAO=edao;
    }
    //just delegate the calls to DAO
    @Override
    public List<Employee> findAll() {
        //delegating calls to DAO
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {
        //just call method defined in dao layer
        employeeDAO.deleteById(theId);
    }
}
