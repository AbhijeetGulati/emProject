package com.example.employeemanager.emProject.rest;

import com.example.employeemanager.emProject.dao.EmployeeDAO;
import com.example.employeemanager.emProject.entity.Employee;
import com.example.employeemanager.emProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //we will make use of the EmployeeService interface methods
    private EmployeeService employeeService;
    //now we will do constructor injection for employeeService
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }


    //expose "/employees" endpoint which will return list of employees
    //we will use get mapping
    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();//making use of methods declared in EmployeeService
    }

}
