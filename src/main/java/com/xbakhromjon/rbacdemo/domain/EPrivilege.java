package com.xbakhromjon.rbacdemo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EPrivilege {
    CREATE_RESOURCE("create resource","POST","/v1/resources");

    private final String name;
    private final String method;
    private final String path;
}
