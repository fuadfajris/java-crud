package com.example.learnspringboot.controller;

import com.example.learnspringboot.model.Token;
import com.example.learnspringboot.model.User;
import com.example.learnspringboot.service.RegistrationService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/registration/checkEmail")
    private ResponseEntity<JSONObject> getAllEmployee(@RequestBody User email) {
        return registrationService.getData(email);
    }

    @PostMapping("/registration/insertToken")
    private ResponseEntity<JSONObject> insertTokenOTP(@RequestBody Token token) {
        return registrationService.insertToken(token);
    }

    @PostMapping("/registration/resendToken")
    private ResponseEntity<JSONObject> resendTokenOTP(@RequestBody Token token) {
        return registrationService.resendToken(token);
    }
}
