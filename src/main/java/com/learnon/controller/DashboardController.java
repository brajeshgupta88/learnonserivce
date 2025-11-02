package com.learnon.controller;

import com.learnon.model.dto.ProviderMetricsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dashboard/providers")
public class DashboardController {

    @GetMapping("/{providerId}/metrics")
    public ResponseEntity<ProviderMetricsDTO> metrics(@PathVariable String providerId,
                                                      @RequestParam(required=false) String from,
                                                      @RequestParam(required=false) String to) {
        ProviderMetricsDTO m = new ProviderMetricsDTO();
        m.setProviderId(providerId);
        m.setTotalEnrollments(0);
        m.setCsatScore(0.0);
        return ResponseEntity.ok(m);
    }
}
