package com.awesomenessstudios.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This Data Transfer Object acts as the bridge between the server and the client.
 * When the client sends data of employee, it will be sent as this class, the values of the data in this class will now be used to convert to the tables
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    public Long id;
    public String firstName;
    public String lastName;
    public String email;
}
