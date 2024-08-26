package com.awesomenessstudios.ems_backend.services;

import com.awesomenessstudios.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
