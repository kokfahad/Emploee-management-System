package com.fahad.employeecrud.dao;

import com.fahad.employeecrud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //define field for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theentityManager){
        entityManager= theentityManager;
    }

    @Override
    public List<Employee> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query (native hibernate query)
        Query<Employee>theQuery =currentSession.createQuery("from Employee",Employee.class);

        //execute query & get the list
        List<Employee> employees = theQuery.getResultList();

        //return the employees
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee
        Employee employee = currentSession.get(Employee.class,id);

        //return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save the employee
         currentSession.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public Employee deleteById(int id) {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete the employee with primary key
        Query query=currentSession.createQuery("delete From Employee where id=:employeeId");
        query.setParameter("employeeId",id);

        query.executeUpdate();

        return null;
    }
}
