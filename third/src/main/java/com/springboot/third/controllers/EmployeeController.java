package com.springboot.third.controllers;

import com.springboot.third.DTO.EmployeeDto;
import com.springboot.third.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/save/employee")
    public ResponseEntity <Void> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/update/employee")
    public ResponseEntity<Void>  updateEmployee(@RequestBody @Valid  EmployeeDto employeeDto){
        employeeService.updateEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable @Valid  Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/get/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable @Valid  Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }
    @GetMapping("/get/all/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }
    @GetMapping("/get/employees/by/name")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByName(@RequestBody @Valid  List<String> names){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeesByName(names));
    }
    @GetMapping("/get/employees/by/ids")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByIds(@RequestBody @Valid  List<Long> ids){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeesByIds(ids));
    }

}
