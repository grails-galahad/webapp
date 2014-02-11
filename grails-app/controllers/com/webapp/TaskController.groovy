package com.webapp

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class TaskController {
    static scaffold = true
    static menuItem = "Tasks"
}
