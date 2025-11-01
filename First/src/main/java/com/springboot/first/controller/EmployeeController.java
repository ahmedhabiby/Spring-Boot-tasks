package com.springboot.first.controller;

import com.springboot.first.model.Employee2;
import com.springboot.first.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee2> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/list/employees")
    public List<Employee2> getAllEmployeesByListOfIds(@RequestBody List<Long> ids){
        return employeeService.getAllEmployeesByListOfIds(ids);
    }
    @PostMapping("/save/employee")
    public void addEmployee(@RequestBody Employee2 employee){
        employeeService.addEmployee(employee);
    }
    @PostMapping("/save/list/employee")
    public void addEmployeeByListOfIds(@RequestBody List<Employee2> employees){
        employeeService.addEmployeeByListOfIds(employees);
    }
    @PutMapping("/update/employee")
    public Employee2 updateEmployee(@RequestBody Employee2 employee){
        return employeeService.updateEmployee(employee);
    }
    @PutMapping("/update/list/employee")
    public List<Employee2> updateEmployeeByListOfEmployees(@RequestBody List<Employee2> employees){
        return employeeService.updateEmployeeByListOfEmployees(employees);
    }
    @DeleteMapping("/delete/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
    @DeleteMapping("/delete/list/employee")
    public void deleteEmployeeByListOfIds(@RequestBody List<Long> ids){
        employeeService.deleteEmployeeByListOfIds(ids);
    }
    @DeleteMapping("/delete/all/employee")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }
    @GetMapping("/search/employee/{name}")
    public Employee2 searchEmployeeByName(@PathVariable String name){
        return employeeService.searchEmployeeByName(name);
    }
    @GetMapping("/search/list/employee/{name}")
    public List<Employee2> searchEmployeeByNames(@PathVariable String name){
        return employeeService.searchEmployeeByNames(name);
    }
}
