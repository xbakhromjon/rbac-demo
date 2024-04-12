package com.xbakhromjon.rbacdemo.repository;

import com.xbakhromjon.rbacdemo.domain.SystemUser;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SystemUserRepository {
    private final List<SystemUser> userList = new ArrayList<>();

    @PostConstruct
    public void preConstruct() {
        userList.add(new SystemUser(UUID.fromString("696e8ddf-6d75-4c8d-a56e-b0f87a1bdb26"), "System Admin", 1));
    }

    public void create(SystemUser user) {
        user.setId(UUID.randomUUID());
        userList.add(user);
    }

    public List<SystemUser> getAll() {
        return userList;
    }
}
