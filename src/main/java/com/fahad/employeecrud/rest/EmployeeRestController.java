package com.fahad.employeecrud.rest;

import com.fahad.employeecrud.dao.EmployeeDAO;
import com.fahad.employeecrud.entity.Employee;
import com.fahad.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
     private EmployeeService employeeService;

    //quick & dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    //expose "/employees" & return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //Get a single employee by id
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("No employee found with this Id : "+ id);
        }
        return employee;
    }

    //POST mapping for creating a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //in case they pass an id as JSON... set it to o
        //this is to force save a new item...instead of update
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    //put mapping for updating an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    //deleting an employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.deleteById(id);
        if (employee == null)
        {
            throw new RuntimeException("No id found to delete");
        }
        return "Delete employee id: "+ id;
    }


}
