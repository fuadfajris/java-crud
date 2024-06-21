package com.example.learnspringboot.service.impl;

import com.example.learnspringboot.model.Employee;
import com.example.learnspringboot.repository.EmployeeRepository;
import com.example.learnspringboot.service.EmployeeService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServcieImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServcieImpl.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<JSONObject> getAllEmployee(Integer pageNo, Integer pageSize, String sortBy) {
        JSONObject jsonResponse = new JSONObject();
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        try {
            Page<Employee> pagedResult = employeeRepository.findAll(paging);

            jsonResponse.put("status", 200);
            jsonResponse.put("data", pagedResult);

        } catch (Exception e) {

            logger.info("Employee Controller Error, caused ");
            logger.info(e.getMessage().toString());
            jsonResponse.put("message", e.getMessage().toString());

        }

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getCustomEmployee(String name) {
        return employeeRepository.customEmployee(name);
    }
}
