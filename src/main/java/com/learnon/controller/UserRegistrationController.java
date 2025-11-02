package com.learnon.controller;

import com.learnon.model.dto.UserAccountDTO;
import com.learnon.service.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Accounts", description = "User registration and CRUD operations for UserAccount")
@Validated
public class UserRegistrationController {

    private final UserAccountService userService;

    public UserRegistrationController(UserAccountService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register a new user")
    @ApiResponse(responseCode = "201", description = "User created")
    @PostMapping
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserCreateRequest req) {
        UserAccountDTO dto = new UserAccountDTO();
        dto.setEmail(req.getEmail());
        dto.setFirstName(req.getFirstName());
        dto.setLastName(req.getLastName());
        dto.setPassword(req.getPassword());
        dto.setCreatedAt(Instant.now().toString());

        try {
            UserAccountDTO saved = userService.create(dto);
            return ResponseEntity.status(201).body(toResponse(saved));
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.status(409).build();
        }
    }

    @Operation(summary = "Get a user by id")
    @ApiResponse(responseCode = "200", description = "User found")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable String id) {
        Optional<UserAccountDTO> opt = userService.findById(id);
        return opt.map(user -> ResponseEntity.ok(toResponse(user)))
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "List all users")
    @ApiResponse(responseCode = "200", description = "Users listed")
    @GetMapping
    public ResponseEntity<List<UserResponse>> listAll() {
        List<UserResponse> out = userService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(out);
    }

    @Operation(summary = "Update an existing user")
    @ApiResponse(responseCode = "200", description = "User updated")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id, @Valid @RequestBody UserUpdateRequest req) {
        UserAccountDTO dto = new UserAccountDTO();
        dto.setEmail(req.getEmail());
        dto.setFirstName(req.getFirstName());
        dto.setLastName(req.getLastName());
        dto.setPassword(req.getPassword());
        Optional<UserAccountDTO> updated = userService.update(id, dto);
        return updated.map(u -> ResponseEntity.ok(toResponse(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a user")
    @ApiResponse(responseCode = "204", description = "User deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /* --- DTOs and helpers (kept local to controller for simplicity) --- */

    public static class UserCreateRequest {
        @Email @NotBlank
        private String email;
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;
        @NotBlank
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class UserUpdateRequest {
        private String email;
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class UserResponse {
        private String id;
        private String email;
        private String firstName;
        private String lastName;
        private String createdAt;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public String getCreatedAt() { return createdAt; }
        public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    }

    private UserResponse toResponse(UserAccountDTO u) {
        UserResponse r = new UserResponse();
        r.setId(u.getId());
        r.setEmail(u.getEmail());
        r.setFirstName(u.getFirstName());
        r.setLastName(u.getLastName());
        r.setCreatedAt(u.getCreatedAt());
        return r;
    }
}