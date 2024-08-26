package com.awesomenessstudios.ems_backend.services.impl;

import com.awesomenessstudios.ems_backend.dto.EmployeeDto;
import com.awesomenessstudios.ems_backend.entities.Employee;
import com.awesomenessstudios.ems_backend.mappers.EmployeeMapper;
import com.awesomenessstudios.ems_backend.repositories.EmployeeRepository;
import com.awesomenessstudios.ems_backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
