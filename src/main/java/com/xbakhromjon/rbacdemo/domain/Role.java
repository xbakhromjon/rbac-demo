package com.xbakhromjon.rbacdemo.domain;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    private Integer id;
    private String name;
    private ArrayList<EPrivilege> privileges = new ArrayList<>();

    public void addPrivilege(EPrivilege privilege) {
        this.privileges.add(privilege);
    }

    public void removePrivilege(EPrivilege privilege) {
        this.privileges.remove(privilege);
    }

}
