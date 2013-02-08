package com.webapp

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class TaskController {
    static scaffold = true
    static menuItem = "Tasks"
}
