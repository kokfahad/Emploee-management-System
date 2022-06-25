package com.fahad.employeecrud.service;

import com.fahad.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public Employee deleteById(int id);
}
