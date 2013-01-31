package com.webapp

class RegistrationController {
    
    def springSecurityService
    
    def index() {
        [user:new User()]
    }
    
    def save() {
        def user = new User(params)
        if (!user.save(flush:true)) {
            render view:"index", model:[user:user]
            return
        }
        
        springSecurityService.reauthenticate user.username
        
        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
        redirect controller:"user", action:"show", id:user.id
    }
}
