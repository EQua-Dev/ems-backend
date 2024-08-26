package com.awesomenessstudios.ems_backend.controllers;

import com.awesomenessstudios.ems_backend.dto.EmployeeDto;
import com.awesomenessstudios.ems_backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * This is the employee controller class.
 * The annotation of "RestController" makes the class exposed as a Spring controller class
 * The annotation of "RequestMapping" is used to define the base url of the controller
 * */

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee REST API
    /*
     * Use the annotation "PostMapping" to declare the function as a Post API
     * It returns a ResponseEntity which passes the return data and the Http status
     * The annotation "RequestBody" expects and receives the json passed by the client and converts it to the EmployeeDto data object
     * */

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee by ID REST API
    /*
     * Use the annotation "GetMapping" to declare the function as a Get API
     * The value in the annotation indicates it as a path parameter
     * It returns a ResponseEntity which passes the return data and the Http status
     * The annotation "PathVariable" expects and receives the value passed in the route path and converts it to a Long
     * */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto foundEmployee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(foundEmployee);
    }

    //Build Get all Employee REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    //Build Update an Employee  REST API

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {

        EmployeeDto updatedEmployeeObj = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(updatedEmployeeObj);
    }

    //Build Delete Employee by ID REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}
