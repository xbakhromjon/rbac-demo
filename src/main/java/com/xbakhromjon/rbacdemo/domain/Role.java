package com.xbakhromjon.rbacdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private List<EPrivilege> privileges = new ArrayList<>();

    public void addPrivilege(EPrivilege privilege) {
        this.privileges.add(privilege);
    }

    public void removePrivilege(EPrivilege privilege) {
        this.privileges.remove(privilege);
    }

}
