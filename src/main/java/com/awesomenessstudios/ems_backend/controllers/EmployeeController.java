package com.awesomenessstudios.ems_backend.controllers;

import com.awesomenessstudios.ems_backend.dto.EmployeeDto;
import com.awesomenessstudios.ems_backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
