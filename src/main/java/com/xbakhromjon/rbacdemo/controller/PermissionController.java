package com.xbakhromjon.rbacdemo.controller;

import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/privileges")
public class PermissionController {

    @GetMapping
    public ResponseEntity<Set<PermissionResponse>> findAll() {
        EnumSet<EPrivilege> privileges = EnumSet.allOf(EPrivilege.class);
        return ResponseEntity.ok(privileges.stream().map(i -> new PermissionResponse(i.name(), i.getDescription(), i.getPath(), i.getMethod()))
                .collect(Collectors.toSet()));
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class PermissionResponse {
    private String name;
    private String description;
    private String path;
    private String method;
}