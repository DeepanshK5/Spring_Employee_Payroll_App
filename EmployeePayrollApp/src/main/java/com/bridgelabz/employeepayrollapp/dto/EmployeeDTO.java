package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 1000, message = "Salary should be at least 1000")
    private double salary;
}
