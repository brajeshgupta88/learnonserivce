package com.learnon.controller;

import com.learnon.model.dto.ProprietorProfileDTO;
import com.learnon.service.ProprietorProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/proprietors")
@Tag(name = "Proprietor Profiles", description = "APIs for managing proprietor profiles")
public class ProprietorProfileController {

    private final ProprietorProfileService profileService;

    public ProprietorProfileController(ProprietorProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Create proprietor profile")
    @PostMapping
    public ResponseEntity<ProprietorProfileDTO> create(@Valid @RequestBody ProprietorProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @Operation(summary = "Get proprietor profile by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProprietorProfileDTO> getById(@PathVariable UUID id) {
        return profileService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get proprietor profile by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ProprietorProfileDTO> getByUserId(@PathVariable UUID userId) {
        return profileService.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "List all proprietor profiles")
    @GetMapping
    public ResponseEntity<List<ProprietorProfileDTO>> listAll() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @Operation(summary = "Update proprietor profile")
    @PutMapping("/{id}")
    public ResponseEntity<ProprietorProfileDTO> update(
            @PathVariable UUID id,
            @Valid @RequestBody ProprietorProfileDTO dto) {
        return profileService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Partially update proprietor profile")
    @PatchMapping("/{id}")
    public ResponseEntity<ProprietorProfileDTO> patch(
            @PathVariable UUID id,
            @RequestBody ProprietorProfileDTO dto) {
        return profileService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete proprietor profile")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}