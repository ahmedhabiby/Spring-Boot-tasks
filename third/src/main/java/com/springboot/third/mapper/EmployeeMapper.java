package com.springboot.third.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.third.DTO.EmployeeDto;
import com.springboot.third.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeDto employeeDto);
    EmployeeDto toDto(Employee employee);
    List<EmployeeDto> toDtoList(List<Employee> employees);
    List<Employee> toEntityList(List<EmployeeDto> employeeDtos);
}
