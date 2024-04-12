package com.xbakhromjon.rbacdemo.repository;

import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.Role;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Slf4j
public class RoleRepository {
    private final List<Role> roleList = new ArrayList<>();
    private int idSequence = 2;

    @PostConstruct
    public void preConstruct() {
        ArrayList<EPrivilege> privilegeList = new ArrayList<>();
        privilegeList.add(EPrivilege.CREATE_ROLE);
        privilegeList.add(EPrivilege.GET_ROLES);
        privilegeList.add(EPrivilege.ROLE_PRIVILEGES);
        privilegeList.add(EPrivilege.GET_SYSTEM_USERS);
        privilegeList.add(EPrivilege.CREATE_SYSTEM_USER);
        roleList.add(new Role(
                1, "ADMIN", privilegeList));
    }

    public void create(Role role) {
        log.info("create: started");
        role.setId(idSequence++);
        roleList.add(role);
    }

    public List<Role> getAll() {
        return roleList;
    }

    public void addPrivilege(Integer id, EPrivilege privilege, boolean add) {
        Role role = roleList.stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("role not found"));
        if (add) {
            role.addPrivilege(privilege);
            return;
        }
        role.removePrivilege(privilege);
    }
}
