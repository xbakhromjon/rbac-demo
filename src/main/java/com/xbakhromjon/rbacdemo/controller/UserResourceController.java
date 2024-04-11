package com.xbakhromjon.rbacdemo.controller;

import com.xbakhromjon.rbacdemo.common.security.PreAuthorize;
import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/resources")
public class UserResourceController {

    @PreAuthorize(privilege = EPrivilege.GET_ALL_RESOURCE)
    @GetMapping
    public ResponseEntity<?> getAll(@PathVariable UUID userId) {
        return ResponseEntity.ok(null);
    }
}
