package com.learnon.controller;

import com.learnon.model.dto.BatchCreateDTO;
import com.learnon.model.dto.BatchDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/services/{serviceId}/batches")
public class BatchController {

    @PostMapping
    public ResponseEntity<BatchDTO> createBatch(@PathVariable String serviceId, @RequestBody BatchCreateDTO dto) {
        BatchDTO b = new BatchDTO();
        b.setId("batch-" + System.currentTimeMillis());
        b.setServiceId(serviceId);
        b.setDays(dto.getDays());
        b.setTime(dto.getTime());
        b.setStartDate(dto.getStartDate());
        b.setEndDate(dto.getEndDate());
        b.setRecurring(dto.isRecurring());
        b.setStaffId(dto.getStaffId());
        b.setLocationId(dto.getLocationId());
        b.setCapacity(dto.getCapacity());
        b.setCreatedAt(Instant.now().toString());
        return ResponseEntity.status(201).body(b);
    }

    @GetMapping
    public ResponseEntity<List<BatchDTO>> listBatches(@PathVariable String serviceId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
