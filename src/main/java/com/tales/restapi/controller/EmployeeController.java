package com.tales.restapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tales.restapi.dto.EmployeeItemDto;
import com.tales.restapi.entity.Employee;
import com.tales.restapi.exception.EmployeeNotFoundException;
import com.tales.restapi.service.EmployeeService;


@RestController
class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<EmployeeItemDto> all() {
    return employeeService.all();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  EmployeeItemDto newEmployee(@RequestBody Employee newEmployee) {
    return employeeService.newEmployee(newEmployee);
  }

  // Single item
  
  @GetMapping("/employees/{id}")
  EmployeeItemDto one(@PathVariable Long id) {
    EmployeeItemDto employee = employeeService.one(id);
    if (employee == null) {
      throw new EmployeeNotFoundException(id);
    }
    return employee;
  }

  @PutMapping("/employees/{id}")
  EmployeeItemDto replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {    
    return employeeService.replaceEmployee(newEmployee, id);
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
  }
}