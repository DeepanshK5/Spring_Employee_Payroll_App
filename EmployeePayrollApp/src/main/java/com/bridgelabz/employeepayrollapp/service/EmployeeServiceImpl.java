package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j  // Lombok Logging
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database");
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        log.info("Saving new employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employee);
        }
        log.warn("Employee with ID {} not found", id);
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        log.warn("Deleting employee with ID: {}", id);
        employeeRepository.deleteById(id);
    }
}
