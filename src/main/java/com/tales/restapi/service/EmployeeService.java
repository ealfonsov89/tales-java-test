package com.tales.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tales.restapi.dto.EmployeeItemDto;
import com.tales.restapi.entity.Employee;
import com.tales.restapi.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeeItemDto> all() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeItemDto> employeeListItems = employees.stream()
            .map(employee -> modelMapper.map(employee, EmployeeItemDto.class))
            .collect(Collectors.toList());
        return employeeListItems;
    }

    public EmployeeItemDto newEmployee(Employee newEmployee) {
        Employee employee = employeeRepository.save(newEmployee);
        EmployeeItemDto employeeListItem = modelMapper.map(employee, EmployeeItemDto.class);
        return employeeListItem;
    }

    public EmployeeItemDto one(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }
        EmployeeItemDto employeeListItem = modelMapper.map(employee, EmployeeItemDto.class);
        return employeeListItem;
    }

    public EmployeeItemDto replaceEmployee(Employee newEmployee, Long id) {
        Employee employee = employeeRepository.findById(id)
                .map(employeeItem -> {
                    employeeItem.setName(newEmployee.getName());
                    employeeItem.setRole(newEmployee.getRole());
                    return employeeRepository.save(employeeItem);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
        EmployeeItemDto employeeListItem = modelMapper.map(employee, EmployeeItemDto.class);
        return employeeListItem;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
