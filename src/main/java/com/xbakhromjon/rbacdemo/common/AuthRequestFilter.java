package com.xbakhromjon.rbacdemo.common;

import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.Role;
import com.xbakhromjon.rbacdemo.domain.SystemUser;
import com.xbakhromjon.rbacdemo.repository.RoleRepository;
import com.xbakhromjon.rbacdemo.repository.SystemUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PipedReader;
import java.util.*;


@Component
@Slf4j
public class AuthRequestFilter extends OncePerRequestFilter {
    @Autowired
    private SystemUserRepository sysUserRepository;
    @Autowired
    private RoleRepository roleRepository;
    private final EnumSet<EPrivilege> PRIVILEGES_SET = EnumSet.allOf(EPrivilege.class);
    private final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("doFilterInternal: started");
        String xUserId = request.getHeader("X-User-Id");
        UUID userId = null;
        try {
            userId = UUID.fromString(xUserId);
        } catch (Exception e) {
            response.getWriter().write("Unauthorized");
            response.setStatus(401);
            return;
        }

        log.info("doFilterInternal: userId={}", userId);
        Optional<EPrivilege> privilegeOpt = getPrivilege(request.getRequestURI(), request.getMethod());
        if (privilegeOpt.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }
        log.info("doFilterInternal: privilege={}", privilegeOpt.get());
        UUID finalUserId = userId;
        SystemUser user = sysUserRepository.getAll().stream().filter(i -> i.getId().equals(finalUserId)).findFirst()
                .orElseThrow(() -> new RuntimeException("current user is not found"));
        log.info("doFilterInternal: sysUser={}", user);
        Role role = roleRepository.getAll().stream().filter(i -> i.getId().equals(user.getRoleId())).findFirst()
                .orElseThrow(() -> new RuntimeException("current user role is not found"));
        log.info("doFilterInternal: role={}", role);
        if (!role.getPrivileges().contains(privilegeOpt.get())) {
            response.getWriter().write("""
                    {"message": "Access Denied"}
                    """);
            response.setHeader("Content-Type", "application/json");
            response.setStatus(403);
            return;
        }
        filterChain.doFilter(request, response);
    }


    private Optional<EPrivilege> getPrivilege(String requestURI, String method) {
        return PRIVILEGES_SET.stream().filter(i -> PATH_MATCHER.match(i.getPath(), requestURI) && Objects.equals(i.getMethod(), method))
                .findFirst();
    }
}
