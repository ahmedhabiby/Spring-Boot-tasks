package com.springboot.third.service.serviceImpl;

import com.springboot.third.DTO.EmailDto;
import com.springboot.third.DTO.EmployeeDto;
import com.springboot.third.mapper.EmailMapper;
import com.springboot.third.mapper.EmployeeMapper;
import com.springboot.third.model.Email;
import com.springboot.third.model.Employee;
import com.springboot.third.repo.EmployeeRepo;
import com.springboot.third.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;
    private EmployeeMapper employeeMapper;
    private EmailMapper emailMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo,EmailMapper emailMapper, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
        this.emailMapper=emailMapper;
    }
    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        if(Objects.nonNull(employeeDto.getId()))throw new IllegalArgumentException("Id must be null");
        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeRepo.save(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        if(Objects.isNull(employeeRepo.findById(id).orElse(null)))throw new
                RuntimeException("Employee not found");
        Employee employee=employeeRepo.findById(id).orElse(null);
        return employeeMapper.toDto(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(Objects.isNull(employeeRepo.findById(id).orElse(null)))throw new
                RuntimeException("Employee not found");
        employeeRepo.deleteById(id);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
            Employee employee=employeeMapper.toEntity(employeeDto);
            if(!employeeRepo.existsById(employee.getId()))throw new
                    RuntimeException("Employee not found");
            employeeRepo.save(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepo.findAll();
        return employees.stream().map(employee -> employeeMapper.toDto(employee)).toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesByName(List<String> names) {
        List<Employee> employees=employeeRepo.findAllByNames(names);
        return employees.stream().map(employee -> employeeMapper.toDto(employee)).toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesByIds(List<Long> ids) {
       List<Employee> employees=employeeRepo.findAllById(ids);
       return employees.stream().map(employee -> employeeMapper.toDto(employee)).toList();
    }

    @Override
    public void saveEmployeeWithListOfEmails(EmployeeDto employeeDto, List<EmailDto> emails) {
            Employee employee=employeeMapper.toEntity(employeeDto);
            List<Email> emailList=emailMapper.toEntityList(emails);
            employee.setEmails(emailList);
            employeeRepo.save(employee);
    }


}
