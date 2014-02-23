package com.webapp

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(['ROLE_USER','ROLE_ADMIN'])
@Transactional(readOnly = true)
class ProjectController {
    static scaffold = true
    static menuItem = "Projects"
}
