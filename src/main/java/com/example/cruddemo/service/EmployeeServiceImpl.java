package com.example.cruddemo.service;


import com.example.cruddemo.dao.EmployeeDao;
import com.example.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }
    @Override
    public Employee findById(int Id) {
        return employeeDao.findById(Id);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int Id) {
        employeeDao.deleteById(Id);
    }
}
