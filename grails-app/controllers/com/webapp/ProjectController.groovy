package com.webapp

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class ProjectController {
    static scaffold = true
    static menuItem = "Projects"
}
