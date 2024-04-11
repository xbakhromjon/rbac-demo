package com.xbakhromjon.rbacdemo.repository;

import com.xbakhromjon.rbacdemo.domain.SystemUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SystemUserRepository {
    private final List<SystemUser> userList = new ArrayList<>();

    public void create(SystemUser user) {
        user.setId(UUID.randomUUID());
        userList.add(user);
    }

    public List<SystemUser> getAll() {
        return userList;
    }
}
