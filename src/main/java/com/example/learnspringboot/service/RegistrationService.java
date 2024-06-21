package com.example.learnspringboot.service;

import com.example.learnspringboot.model.Token;
import com.example.learnspringboot.model.User;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService
{
    public ResponseEntity<JSONObject> getData(User email);
    public ResponseEntity<JSONObject> insertToken(Token token);
    public ResponseEntity<JSONObject> resendToken(Token token);
}
