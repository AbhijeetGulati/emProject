package com.example.employeemanager.emProject.dao;

import com.example.employeemanager.emProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //define entityManager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager em){
        entityManager=em;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query=entityManager.createQuery("FROM Employee",Employee.class);
        //now receive all these in a list and return it
        List<Employee> employees=query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //first we will find the employee based on id
        Employee emp=entityManager.find(Employee.class,theId);
        //return the employee
        return emp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //we will use the merge method of entity manager
        Employee dbEmployee=entityManager.merge(theEmployee);
        //merge feature will perform a save or an update based on the id
        return dbEmployee;//it has updated id from the database
    }

    @Override
    public void deleteById(int theId) {
     //find the employee based on id
        Employee removeEmployee=entityManager.find(Employee.class,theId);

        //remove the employee
        entityManager.remove(removeEmployee);
    }
}
