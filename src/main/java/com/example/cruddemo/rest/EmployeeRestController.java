package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class EmployeeRestController {
  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("employees/{employeeId}")
  public Employee getEmployeeId(@PathVariable int employeeId) {
    return employeeService.findById(employeeId);
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee theEmployee) {
    theEmployee.setId(0);
    Employee newEmployee = employeeService.save(theEmployee);
    return newEmployee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee theEmployee) {
    Employee updatedEmployee = employeeService.save(theEmployee);
    return updatedEmployee;
  }

  @DeleteMapping("employees/{employeeId}")
  public String deleteById(@PathVariable int employeeId) {
    Employee tempEmployee = employeeService.findById(employeeId);
    if(tempEmployee == null){
      throw new RuntimeException("Employee id not found :- " + employeeId);
    }
    employeeService.deleteById(employeeId);
    return "Deleted employee id: -" + employeeId;
  }
}