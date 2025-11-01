package com.springboot.first.service;

import com.springboot.first.model.Employee2;

import java.util.List;

public interface EmployeeService {
    List<Employee2> getAllEmployees();
    List<Employee2> getAllEmployeesByListOfIds(List<Long> ids);
    void addEmployee(Employee2 employee);
    void addEmployeeByListOfIds(List<Employee2> employees);
    Employee2 updateEmployee(Employee2 employee);
    List<Employee2> updateEmployeeByListOfEmployees(List<Employee2> employees);
    void deleteEmployee(Long id);
    void deleteEmployeeByListOfIds(List<Long> ids);
    void deleteAllEmployees();
    Employee2 searchEmployeeByName(String name);
    List<Employee2> searchEmployeeByNames(String name);


}
