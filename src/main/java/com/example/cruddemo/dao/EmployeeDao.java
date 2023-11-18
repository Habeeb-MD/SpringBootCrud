package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int Id);
    Employee save(Employee theEmployee);

    void deleteById(int Id);
}
