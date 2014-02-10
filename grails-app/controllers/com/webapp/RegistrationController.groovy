package com.webapp

import org.springframework.security.core.context.SecurityContextHolder

class RegistrationController {
    
    def springSecurityService
    
    def index() {
        respond new User()
    }
    
    def save() {
        def user = new User(params)
        user.validate()
        if (params.terms != 'on') user.errors.reject("registration.terms.required.message", null, "Please accept the terms of use")
        
        if (user.hasErrors()) {
            render view:"index", model:[user:user]
            return
        }
        
        user.save(failOnEror:true)
        def roleUser = Role.findByAuthority('ROLE_USER')
        UserRole.create user, roleUser, true
        
        springSecurityService.reauthenticate user.email
        
        sendMail {
           to user.email
           subject "Welcome to ${meta(name: 'app.name')}"
           html view:"/emailTemplates/registration", model:[user:user]
        }
        
        flash.message = message(code: 'welcome.message', default: 'Welcome!')
        redirect controller:"project", action:"list", id:user.id
    }
}
