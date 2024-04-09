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
public interface ResourceController {
    @PreAuthorize(type = ETokenType.USER)
    ResponseEntity<Void> create(@RequestBody Object request);

    @PreAuthorize(type = ETokenType.USER)
    ResponseEntity<Void> update(@RequestBody Object request);

    @PreAuthorize(type = ETokenType.USER)
    ResponseEntity<Void> getOne(@RequestBody Serializable ID);

    @PreAuthorize(type = ETokenType.USER)
    ResponseEntity<Void> findAll(@RequestBody Object filter);

    @PreAuthorize(type = ETokenType.USER)
    ResponseEntity<Void> delete(@RequestBody Serializable ID);
}
