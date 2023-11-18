package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class EmployeeDaoJpaImpl implements EmployeeDao{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int Id) {
        Employee theEmployee = entityManager.find(Employee.class,Id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee newEmployee = entityManager.merge(theEmployee);
        return newEmployee;
    }

    @Override
    public void deleteById(int Id) {
        Employee theEmployee = entityManager.find(Employee.class,Id);
        entityManager.remove(theEmployee);
    }
}
