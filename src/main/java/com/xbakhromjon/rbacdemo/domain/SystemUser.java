package com.xbakhromjon.rbacdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {
    private UUID id;
    private String name;
    private Integer roleId;
}
