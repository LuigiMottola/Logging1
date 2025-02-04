package com.example.Logging1.controllers;

import com.example.Logging1.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/basicController")
public class BasicController {

    @Autowired
    private BasicService basicService;

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public ResponseEntity<String> getWelcome(){
        String message = "Welcome";
        logger.info("Welcome message requested");
        return ResponseEntity.ok().body(message);
    }

    @GetMapping("/exponent")
    public ResponseEntity<String> getExponent(){
        logger.info("Calculation done");
        return ResponseEntity.ok().body(String.valueOf(basicService.exponent()));
    }

    @GetMapping("/get-errors")
    public ResponseEntity<String> getErrors(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }

}