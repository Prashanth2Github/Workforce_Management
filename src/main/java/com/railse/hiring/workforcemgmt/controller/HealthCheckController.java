package com.railse.hiring.workforcemgmt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("✅ Spring Boot Application is UP and RUNNING!");
    }
}
