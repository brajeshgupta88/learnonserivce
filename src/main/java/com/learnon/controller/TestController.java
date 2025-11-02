package com.learnon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/test")
@Tag(name = "Test", description = "Simple endpoints for health checks and testing")
public class TestController {

    @Operation(summary = "Health check", description = "Returns service health status")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Service is healthy")
    })
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "timestamp", Instant.now().toString()
        ));
    }

    @Operation(summary = "Ping", description = "Simple ping endpoint that returns pong")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pong returned")
    })
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @Operation(summary = "Echo", description = "Echoes back a JSON payload")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payload echoed back"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/echo")
    public ResponseEntity<EchoResponse> echo(@RequestBody EchoRequest req) {
        EchoResponse res = new EchoResponse();
        res.setMessage(req.getMessage());
        res.setReceivedAt(Instant.now().toString());
        return ResponseEntity.ok(res);
    }

    // simple request/response DTOs used only for this test controller
    public static class EchoRequest {
        private String message;
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    public static class EchoResponse {
        private String message;
        private String receivedAt;
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getReceivedAt() { return receivedAt; }
        public void setReceivedAt(String receivedAt) { this.receivedAt = receivedAt; }
    }
}