package com.springboot.third.service;

import com.springboot.third.DTO.EmailDto;
import com.springboot.third.DTO.EmployeeDto;
import com.springboot.third.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    void updateEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    List<EmployeeDto> getEmployeesByName(List<String> names);
    List<EmployeeDto> getEmployeesByIds(List<Long> ids);
    void saveEmployeeWithListOfEmails(EmployeeDto employeeDto, List<EmailDto> emails);

}
