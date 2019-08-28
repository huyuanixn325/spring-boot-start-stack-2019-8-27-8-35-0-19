package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

   private static List<Employee> employees = new ArrayList<Employee>(){{
        add(new Employee(1,"xiaona",19,"female"));
       add(new Employee(2,"xiaoyang",20,"female"));
       add(new Employee(3,"xiaoqing",22,"male"));
       add(new Employee(4,"xiaofei",21,"male"));
    }};


    public List<Employee> queryEmployees(){
        return employees;
    }

    public Employee loadEmployeeByEmployeeID(int employeeID){
        for(Employee employee:employees){
            if (employee.getEmployeeID()==employeeID){
                return employee;
            }
        }
        return null;
    }



    public List<Employee> queryEmployeeLinkName(String name){
        List<Employee> employeesLikeName = new ArrayList<>();
        if (name==null){
            return employees;
        }
        for (Employee employee : employees){
            if (employee.getEmployeeName().contains(name)){
                employeesLikeName.add(employee);
            }
        }
        return employeesLikeName;
    }

    public void addEmployees(Employee employee) {
        employees.add(employee);
    }
}
