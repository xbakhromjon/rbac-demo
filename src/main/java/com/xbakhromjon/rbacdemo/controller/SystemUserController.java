package com.xbakhromjon.rbacdemo.controller;

import com.xbakhromjon.rbacdemo.domain.SystemUser;
import com.xbakhromjon.rbacdemo.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys-users")
public class SystemUserController {
    @Autowired
    private SystemUserRepository repository;


    @GetMapping
    public ResponseEntity<List<SystemUser>> findAll() {
        return ResponseEntity.ok(repository.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SystemUser user) {
        repository.create(user);
        return ResponseEntity.ok(null);
    }
}
