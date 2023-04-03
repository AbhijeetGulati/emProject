package com.example.employeemanager.emProject.rest;

import com.example.employeemanager.emProject.dao.EmployeeDAO;
import com.example.employeemanager.emProject.entity.Employee;
import com.example.employeemanager.emProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //to GET single employee based on employee id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        //we will use method we defined in service implementation to get the reqd employee
        Employee theEmployee=employeeService.findById(employeeId);

        //exception handling
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found : "+employeeId);
        }

        return theEmployee;
    }

    //add mapping for POST/employees -> add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //in case an id is passed in JSON set it to zero
        //this will force a save instead of an update

        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for updating employee
    //using PUT HTTP Method
    // PUT/employees
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;//updated employee
    }

    //add mapping to delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        //find the employee based on the id that you want to delete
        Employee temp=employeeService.findById(employeeId);
        //throw exception if null
        if(temp==null){
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        //now delete the employee that we found
        employeeService.deleteById(employeeId);
        return "Employee has been deleted whose id was :"+employeeId;

    }
}
