package com.xbakhromjon.rbacdemo.repository;

import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepository {
    private final List<Role> roleList = new ArrayList<>();
    private int idSequence = 1;

    public void create(Role role) {
        role.setId(idSequence++);
        roleList.add(role);
    }

    public List<Role> getAll() {
        return roleList;
    }

    public void addPrivilege(Integer id, EPrivilege privilege, boolean add) {
        Role role = roleList.stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow();
        if (add) {
            role.addPrivilege(privilege);
            return;
        }
        role.removePrivilege(privilege);
    }
}
