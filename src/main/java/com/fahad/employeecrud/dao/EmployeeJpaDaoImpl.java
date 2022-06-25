package com.fahad.employeecrud.dao;

import com.fahad.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeJpaDaoImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeJpaDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create query
        Query theQuery = entityManager.createQuery("from Employee");
        //execute query & get resultlist
        List<Employee>employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee deleteById(int id) {
        return null;
    }
}
