package com.xbakhromjon.rbacdemo.domain.model;

import com.xbakhromjon.rbacdemo.domain.enumeration.EPrivilege;

import java.util.List;

public class Role {
    private Integer id;
    private String name;
    private List<EPrivilege> privileges;
}
