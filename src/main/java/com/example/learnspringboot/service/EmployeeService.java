package com.example.learnspringboot.service;

import com.example.learnspringboot.model.Employee;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public ResponseEntity<JSONObject> getAllEmployee(Integer pageNo, Integer pageSize, String sortBy);
    public Employee addNewEmployee(Employee employee);
    public List<Employee> getCustomEmployee(String name);
}
