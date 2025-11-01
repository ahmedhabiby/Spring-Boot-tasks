package com.springboot.first.service.impl;

import com.springboot.first.Repo.EmployeeRepo;
import com.springboot.first.model.Employee2;
import com.springboot.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public List<Employee2> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee2> getAllEmployeesByListOfIds(List<Long> ids) {
        return employeeRepo.findAllById(ids);
    }

    @Override
    public void addEmployee(Employee2 employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void addEmployeeByListOfIds(List<Employee2> employees) {
        employeeRepo.saveAll(employees);
    }

    @Override
    public Employee2 updateEmployee(Employee2 employee) {
         employee.setId(employee.getId());
         employee.setAge(employee.getAge());
         employee.setName(employee.getName());
         employee.setPhoneNumber(employee.getPhoneNumber());
         Employee2 employee2 = employeeRepo.save(employee);
        return employee2;
    }

    @Override
    public List<Employee2> updateEmployeeByListOfEmployees(List<Employee2> employees) {
        List<Employee2> employee2 = new ArrayList<>();
        for(Employee2 employee:employees){
            employee.setId(employee.getId());
            employee.setAge(employee.getAge());
            employee.setName(employee.getName());
            employee.setPhoneNumber(employee.getPhoneNumber());
            employeeRepo.save(employee);
            employee2.add(employee);
        }
        return employee2;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void deleteEmployeeByListOfIds(List<Long> ids) {
        employeeRepo.deleteAllById(ids);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }

    @Override
    public Employee2 searchEmployeeByName(String name) {
        List<Employee2> employees=employeeRepo.findAll();
        for(Employee2 employee:employees){
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee2> searchEmployeeByNames(String name) {
        return  employeeRepo.findByNameStartingWith(name);
    }
}
