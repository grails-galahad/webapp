package com.webapp

import grails.plugin.springsecurity.userdetails.GrailsUser

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class ExtUserDetails extends GrailsUser {
    static final long serialVersionUID = 42L;
    
    final String fullName

    ExtUserDetails(String email, String password, boolean enabled,
                  boolean accountNonExpired, boolean credentialsNonExpired,
                  boolean accountNonLocked,
                  Collection<GrantedAuthority> authorities,
                  long id, String fullName) {
        super(email, password, enabled, accountNonExpired,
        credentialsNonExpired, accountNonLocked, authorities, id)

        this.fullName = fullName
    }
}
