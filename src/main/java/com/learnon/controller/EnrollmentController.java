package com.learnon.controller;

import com.learnon.model.dto.EnrollmentCreateDTO;
import com.learnon.model.dto.EnrollmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/batches/{batchId}/enrollments")
public class EnrollmentController {

    @PostMapping
    public ResponseEntity<EnrollmentDTO> enroll(@PathVariable String batchId, @RequestBody EnrollmentCreateDTO dto) {
        EnrollmentDTO e = new EnrollmentDTO();
        e.setId("enr-" + System.currentTimeMillis());
        e.setBatchId(batchId);
        e.setCustomerId(dto.getCustomerId());
        e.setLearner(dto.getLearner());
        e.setStatus("pending");
        e.setAttended(false);
        e.setCreatedAt(Instant.now().toString());
        return ResponseEntity.status(201).body(e);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> listEnrollments(@PathVariable String batchId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
