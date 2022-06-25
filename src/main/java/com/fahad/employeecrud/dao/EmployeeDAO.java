package com.fahad.employeecrud.dao;

import com.fahad.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public Employee deleteById(int id);
}
