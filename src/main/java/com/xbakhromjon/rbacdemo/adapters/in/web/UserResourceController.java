package com.xbakhromjon.rbacdemo.adapters.in.web;

import com.xbakhromjon.rbacdemo.common.security.PreAuthorize;
import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.ETokenType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/resources")
public interface UserResourceController {
    @PreAuthorize(privilege = EPrivilege.CREATE_RESOURCE)

    ResponseEntity<Void> create(@RequestBody Object request);

    @PreAuthorize(privilege = EPrivilege.CREATE_RESOURCE)
    ResponseEntity<Void> update(@RequestBody Object request);

    @PreAuthorize(privilege = EPrivilege.CREATE_RESOURCE)
    ResponseEntity<Void> getOne(@RequestBody Serializable ID);

    @PreAuthorize(privilege = EPrivilege.CREATE_RESOURCE)
    ResponseEntity<Void> findAll(@RequestBody Object filter);

    @PreAuthorize(privilege = EPrivilege.CREATE_RESOURCE)
    ResponseEntity<Void> delete(@RequestBody Serializable ID);
}
