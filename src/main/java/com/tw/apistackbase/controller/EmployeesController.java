package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeesController {

    @GetMapping
    public ResponseEntity<List<Employee>> queryEmployees(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmployeeID(11);
        employee.setEmployeeName("小娜");
        employee.setAge(18);
        employee.setGender("female");
        employees.add(employee);
        return ResponseEntity.ok(employees);
    }
}
