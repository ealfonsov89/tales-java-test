package com.tales.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tales.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
