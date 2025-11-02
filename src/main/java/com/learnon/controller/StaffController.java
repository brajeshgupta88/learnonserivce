package com.learnon.controller;

import com.learnon.model.dto.StaffCreateDTO;
import com.learnon.model.dto.StaffDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/providers/{providerId}/staff")
public class StaffController {

    @PostMapping
    public ResponseEntity<StaffDTO> addStaff(@PathVariable String providerId, @RequestBody StaffCreateDTO dto) {
        StaffDTO s = new StaffDTO();
        s.setId("staff-" + System.currentTimeMillis());
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setMobile(dto.getMobile());
        s.setRole(dto.getRole());
        s.setExpertise(dto.getExpertise());
        return ResponseEntity.status(201).body(s);
    }

    @GetMapping
    public ResponseEntity<List<StaffDTO>> listStaff(@PathVariable String providerId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
