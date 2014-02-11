package com.webapp

import grails.plugin.springsecurity.userdetails.GrailsUser
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class ExtUserDetailsService implements GrailsUserDetailsService {

    static final List NO_ROLES = [new GrantedAuthorityImpl(SpringSecurityUtils.NO_ROLE)]

    UserDetails loadUserByUsername(String username, boolean loadRoles) throws UsernameNotFoundException {
        return loadUserByUsername(username)
    }

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User.withTransaction { status ->
            User user = User.findByEmail(email)
            if (!user) throw new UsernameNotFoundException('User not found', email)

            def authorities = user.authorities.collect { new GrantedAuthorityImpl(it.authority) }

            return new ExtUserDetails(user.email, user.password, user.enabled,
                                     !user.accountExpired, !user.passwordExpired,
                                     !user.accountLocked, authorities ?: NO_ROLES, user.id,
                                     user.fullName)
        }
    }
}
