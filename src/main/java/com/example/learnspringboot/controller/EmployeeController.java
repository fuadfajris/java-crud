package com.example.learnspringboot.controller;

import com.example.learnspringboot.model.Employee;
import com.example.learnspringboot.service.EmployeeService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employeeTest")
    private String test() {
        return "Test";
    }

    @GetMapping("/employee")
    private ResponseEntity<JSONObject> getAllEmployee(@RequestParam(defaultValue = "0") Integer pageNo,
                                                      @RequestParam(defaultValue = "5") Integer pageSize,
                                                      @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getAllEmployee(pageNo, pageSize, sortBy);
    }

    @PostMapping("/employee")
    private ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/custom")
    private ResponseEntity getEmployee(@RequestParam String name) {
        return ResponseEntity.ok().body(employeeService.getCustomEmployee(name));
    }

}
