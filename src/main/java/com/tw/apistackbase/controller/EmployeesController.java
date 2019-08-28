package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;
//    @GetMapping
//    public ResponseEntity<List<Employee>> queryEmployees(){
//        return ResponseEntity.ok(employeeService.loadEmployees());
//    }

    @GetMapping("/{employeeID}")
    public ResponseEntity<Employee> queryEmployee(@PathVariable int employeeID){
        return ResponseEntity.ok(employeeService.loadEmployeeByEmployeeID(employeeID));
    }
    @GetMapping
    public ResponseEntity<List<Employee>> queryEmployees(@RequestParam(required = false) String employeeName){
        System.out.println(employeeName);
        return ResponseEntity.ok(employeeService.queryEmployeeLinkName(employeeName));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> insertEmployees(@RequestBody Employee employee){
        employeeService.addEmployees(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> updateEmployees(@RequestBody  Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
