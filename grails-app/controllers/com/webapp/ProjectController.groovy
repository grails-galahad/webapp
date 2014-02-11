package com.webapp

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class ProjectController {
    static scaffold = true
    static menuItem = "Projects"
}
