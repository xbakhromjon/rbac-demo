package com.xbakhromjon.rbacdemo.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SystemUser {
    private UUID id;
    private String name;
    private Integer roleId;
}
