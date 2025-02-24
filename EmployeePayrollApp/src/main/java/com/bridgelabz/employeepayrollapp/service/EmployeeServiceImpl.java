package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList = new ArrayList<>(); // Temporary storage

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList; // Fetch from memory instead of database
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        employee.setId((long) (employeeList.size() + 1)); // Manually assigning ID
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                Employee employee = employeeList.get(i);
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                return employee;
            }
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
