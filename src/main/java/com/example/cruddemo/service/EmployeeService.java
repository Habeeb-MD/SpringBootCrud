package com.example.cruddemo.service;

import com.example.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int Id) ;

    public Employee save(Employee theEmployee);

    public void deleteById(int Id);
}
