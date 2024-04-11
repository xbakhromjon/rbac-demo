package com.xbakhromjon.rbacdemo.controller;

import com.xbakhromjon.rbacdemo.common.security.PreAuthorize;
import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(null);
    }
}
