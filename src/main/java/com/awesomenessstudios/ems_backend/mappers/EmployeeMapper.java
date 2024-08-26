package com.awesomenessstudios.ems_backend.mappers;

import com.awesomenessstudios.ems_backend.dto.EmployeeDto;
import com.awesomenessstudios.ems_backend.entities.Employee;

/*
 * This class acts as the bridge for data transfer between client and server.
 * The class has mapper objects that accept the employee body from the client request and converts to the employee dto POJO which the database understands and vice versa
 * */
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.lastName,
                employeeDto.getEmail()
        );
    }
}
