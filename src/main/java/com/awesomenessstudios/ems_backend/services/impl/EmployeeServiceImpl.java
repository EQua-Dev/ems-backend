package com.awesomenessstudios.ems_backend.services.impl;

import com.awesomenessstudios.ems_backend.dto.EmployeeDto;
import com.awesomenessstudios.ems_backend.entities.Employee;
import com.awesomenessstudios.ems_backend.exceptions.ResourceNotFoundException;
import com.awesomenessstudios.ems_backend.mappers.EmployeeMapper;
import com.awesomenessstudios.ems_backend.repositories.EmployeeRepository;
import com.awesomenessstudios.ems_backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * This is the employee service implementation class.
 * It implements (overrides) the functions defined in the employee service interface
 * It also injects employee repository in order to access the JPA functions extended in the repository
 * The "all arg constructor" efficiently injects the arguments and functions accessible from the repository
 * */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("No employee found with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(foundEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for id: " + employeeId));

        employee.setFirstName(updatedEmployee.firstName);
        employee.setLastName(updatedEmployee.lastName);
        employee.setEmail(updatedEmployee.email);

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for id: " + employeeId));

        employeeRepository.deleteById(employeeId);

    }
}
