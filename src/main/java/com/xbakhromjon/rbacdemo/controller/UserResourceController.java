package com.xbakhromjon.rbacdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/resources")
public class UserResourceController {

    @GetMapping
    public ResponseEntity<?> getAll(@PathVariable UUID userId) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<?> create(@PathVariable UUID userId) {
        return ResponseEntity.ok(null);
    }
}
