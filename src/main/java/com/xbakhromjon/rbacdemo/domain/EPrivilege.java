package com.xbakhromjon.rbacdemo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EPrivilege {
    CREATE_ROLE("create role", "POST", "/roles"),
    GET_ROLES("get all roles", "GET", "/roles"),
    ROLE_PRIVILEGES("add/remove privilege", "PUT", "/roles/{id}/privileges"),
    GET_SYSTEM_USERS("get system users", "GET", "/sys-users"),
    CREATE_SYSTEM_USER("create sysem user", "POST", "/sys-users"),
    GET_ALL_RESOURCE("get all user's resources", "GET", "/users/{userId}/resources"),
    CREATE_RESOURCE("create resource to user", "POST", "/users/{userId}/resources");


    private final String description;
    private final String method;
    private final String path;
}
