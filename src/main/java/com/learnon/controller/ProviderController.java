package com.learnon.controller;

import com.learnon.model.dto.ProviderOnboardingDTO;
import com.learnon.model.dto.ProviderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

    @PostMapping
    public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderOnboardingDTO onboarding) {
        // Stubbed: save onboarding progress or create provider
        ProviderDTO p = new ProviderDTO();
        p.setId("prov-123");
        p.setBusinessName(onboarding.getBusinessName() == null ? "My Academy" : onboarding.getBusinessName());
        p.setBusinessType(onboarding.getBusinessType());
        p.setServiceTypes(onboarding.getServiceTypes());
        p.setProfileCompleted(false);
        p.setCreatedAt(Instant.now().toString());
        return ResponseEntity.status(201).body(p);
    }

    @GetMapping
    public ResponseEntity<?> listProviders(@RequestParam(required=false) Double lat,
                                           @RequestParam(required=false) Double lng,
                                           @RequestParam(defaultValue = "5") Integer radius_km,
                                           @RequestParam(required=false) String q) {
        // Stubbed: return empty list (implement search + geo filtering)
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<ProviderDTO> getProvider(@PathVariable String providerId) {
        ProviderDTO p = new ProviderDTO();
        p.setId(providerId);
        p.setBusinessName("Example Academy");
        p.setBusinessType("MultiStaff");
        p.setProfileCompleted(true);
        p.setCreatedAt(Instant.now().toString());
        return ResponseEntity.ok(p);
    }

    @PatchMapping("/{providerId}")
    public ResponseEntity<ProviderDTO> updateProvider(@PathVariable String providerId, @RequestBody ProviderOnboardingDTO dto) {
        // Stubbed: return merged
        ProviderDTO p = new ProviderDTO();
        p.setId(providerId);
        p.setBusinessName(dto.getBusinessName());
        p.setBusinessType(dto.getBusinessType());
        p.setProfileCompleted(true);
        p.setCreatedAt(Instant.now().toString());
        return ResponseEntity.ok(p);
    }
}
