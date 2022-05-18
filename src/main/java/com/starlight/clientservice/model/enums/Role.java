package com.starlight.clientservice.model.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {

    USER(getLIstOfUserPermissions());

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

    private static Set<Permission> getLIstOfUserPermissions() {
        Set<Permission> permissions = new HashSet<>();
        permissions.add(Permission.USER_READ);
        permissions.add(Permission.USER_WRITE);
        return permissions;
    }
}
