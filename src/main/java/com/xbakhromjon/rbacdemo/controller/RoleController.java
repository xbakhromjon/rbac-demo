package com.xbakhromjon.rbacdemo.controller;


import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.Role;
import com.xbakhromjon.rbacdemo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleRepository repository;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Role role) {
        repository.create(role);
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(repository.getAll());
    }

    @PutMapping("/{id}/privileges")
    public ResponseEntity<?> privileges(
            @PathVariable Integer id,
            @RequestParam EPrivilege privilege, @RequestParam boolean add) {
        repository.addPrivilege(id, privilege, add);
        return ResponseEntity.ok(null);
    }
}
