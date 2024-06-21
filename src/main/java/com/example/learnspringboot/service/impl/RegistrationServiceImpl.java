package com.example.learnspringboot.service.impl;

import com.example.learnspringboot.model.Token;
import com.example.learnspringboot.model.User;
import com.example.learnspringboot.repository.RegistrationRepository;
import com.example.learnspringboot.repository.TokenRepository;
import com.example.learnspringboot.service.RegistrationService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public ResponseEntity<JSONObject> getData(User email) {
        JSONObject jsonResponse = new JSONObject();

        try {
            Map<String, Object> result = registrationRepository.getDataUser(email.getEmail());

            if (result.size() < 1) {
                //code otp
                Random random = new Random();
                String otp = String.format("%04d", random.nextInt(10000));

                //expired
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime expired = LocalDateTime.now().plusMinutes(10);
            }

            jsonResponse.put("status", 200);
            jsonResponse.put("data", result);
        } catch (Exception e) {
            jsonResponse.put("status", 400);
            jsonResponse.put("result", "error");
            jsonResponse.put("message", e.getMessage().toString());
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JSONObject> insertToken(Token token) {
        String email = token.getEmail();
        String otp = token.getToken();
        LocalDateTime exipred = token.getExpired_On();
        String use = token.getUsed_For();

        JSONObject jsonResponse = new JSONObject();
        try {
            Map<String, Object> result = registrationRepository.insertToken(email, otp, exipred, use);
//            Token tokens = tokenRepository.save(token);
            jsonResponse.put("status", 200);
            jsonResponse.put("data", result);
        } catch (Exception e) {
            jsonResponse.put("status", 400);
            jsonResponse.put("result", "error");
            jsonResponse.put("message", e.getMessage().toString());
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JSONObject> resendToken(Token token) {
        String email = token.getEmail();
        LocalDateTime expired = token.getExpired_On();
        LocalDateTime now = LocalDateTime.now();
        JSONObject jsonResponse = new JSONObject();
        System.out.println("email : " + email);
        System.out.println("expired : " + expired);
        System.out.println("now : " + now);

//        if (now > expired){
//
//        } else {
//
//        }

        try {

//            Map<String, Object> result = registrationRepository.getDataUser2(email, now);

            //code otp
            Random random = new Random();
            String otp = String.format("%04d", random.nextInt(10000));

            jsonResponse.put("status", 200);
            jsonResponse.put("data", "test");
        } catch (Exception e) {
            jsonResponse.put("status", 400);
            jsonResponse.put("result", "error");
            jsonResponse.put("message", e.getMessage().toString());
        }

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
