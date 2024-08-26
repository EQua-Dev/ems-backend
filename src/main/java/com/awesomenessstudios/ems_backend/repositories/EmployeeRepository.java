package com.awesomenessstudios.ems_backend.repositories;

import com.awesomenessstudios.ems_backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Extends the JPA repository that takes two parameters: the type of the entity (the data model class) and type of the primary
 * This repository will contain the CRUD operations to perform on the passed entity
 * PS: All operations are transactional, such that all operations being performed on the table must succeed else the changes will be rolled back
 * */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
