package com.learnon.controller;

import com.learnon.model.dto.CustomerDTO;
import com.learnon.model.dto.CustomerRegistrationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> register(@RequestBody CustomerRegistrationDTO dto) {
        CustomerDTO c = new CustomerDTO();
        c.setId("cust-" + System.currentTimeMillis());
        c.setEmail(dto.getEmail());
        c.setFirstName(dto.getFirstName());
        c.setLastName(dto.getLastName());
        c.setCountry(dto.getCountry());
        c.setMobile(dto.getMobile());
        c.setCreatedAt(Instant.now().toString());
        return ResponseEntity.status(201).body(c);
    }

    @GetMapping("/{customerId}/appointments")
    public ResponseEntity<List<Object>> appointments(@PathVariable String customerId, @RequestParam(defaultValue = "upcoming") String status) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
