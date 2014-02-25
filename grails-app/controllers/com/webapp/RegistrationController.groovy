package com.webapp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RegistrationController {
    
    def springSecurityService
	
	static allowedMethods = [save: "POST"]
    
    def index() {
        respond new User()
    }

    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }
		
		if (params.terms != 'on') userInstance.errors.reject("registration.terms.required.message", null, "Please accept the terms of use")
		
        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'index'
            return
        }

        userInstance.save flush:true
        def roleUser = Role.findByAuthority('ROLE_USER')
        UserRole.create userInstance, roleUser, true
		
		springSecurityService.reauthenticate userInstance.email

        sendMail {
           to userInstance.email
           subject "Welcome to ${meta(name: 'app.name')}"
           html view:"/emailTemplates/registration", model:[user:userInstance]
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'welcome.message', default: 'Welcome!')
                redirect controller:"project", action:"index"
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }
	
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userInstance.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
