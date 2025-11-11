package com.springboot.third.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.third.model.Email;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    private Long id;

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Min(value = 16, message = "Age must be greater than 15")
    @Max(value = 39, message = "Age must be less than 40")
    private int age;
    @DecimalMin(value = "5001", message = "Salary must be greater than 5000")
    @DecimalMax(value = "9999", message = "Salary must be less than 10000")
    private double salary;

    private List<Email> emails;

}
