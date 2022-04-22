package com.francesca.pascalau.controller;

import com.francesca.pascalau.data.entities.Employee;
import com.francesca.pascalau.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AppController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findEmployees();

        return new ResponseEntity<>(employees, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable(value = "id") Long employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);

        return new ResponseEntity<>(employee, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        Employee saved = employeeService.save(employee);

        return new ResponseEntity<>(saved, new HttpHeaders(), HttpStatus.OK);
    }
}
