package com.learnon.controller;

import com.learnon.model.dto.ServiceCreateDTO;
import com.learnon.model.dto.ServiceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/providers/{providerId}/services")
@Tag(name = "Service Management", description = "APIs for managing provider services")
public class ServiceController {

    @Operation(summary = "Create a new service",
            description = "Creates a new service for the specified provider with the given details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", 
                    description = "Service created successfully",
                    content = @Content(schema = @Schema(implementation = ServiceDTO.class))),
            @ApiResponse(responseCode = "400", 
                    description = "Invalid input data"),
            @ApiResponse(responseCode = "404", 
                    description = "Provider not found")
    })
    @PostMapping
    public ResponseEntity<ServiceDTO> createService(
            @Parameter(description = "ID of the provider", required = true)
            @PathVariable String providerId,
            
            @Parameter(description = "Service details to create", required = true)
            @RequestBody ServiceCreateDTO dto) {
        ServiceDTO s = new ServiceDTO();
        s.setId("svc-" + System.currentTimeMillis());
        s.setProviderId(providerId);
        s.setTitle(dto.getTitle());
        s.setCategory(dto.getCategory());
        s.setDurationMinutes(dto.getDurationMinutes());
        s.setPrice(dto.getPrice());
        s.setCapacity(dto.getCapacity());
        s.setCreatedAt(Instant.now().toString());
        return ResponseEntity.status(201).body(s);
    }

    @Operation(summary = "List all services",
            description = "Retrieves all services associated with the specified provider")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", 
                    description = "Successfully retrieved the list of services",
                    content = @Content(schema = @Schema(implementation = ServiceDTO.class))),
            @ApiResponse(responseCode = "404", 
                    description = "Provider not found")
    })
    @GetMapping
    public ResponseEntity<List<ServiceDTO>> listServices(
            @Parameter(description = "ID of the provider", required = true)
            @PathVariable String providerId) {
        // Stubbed: return empty list
        return ResponseEntity.ok(new ArrayList<>());
    }
}
