package com.webapp

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class TaskController {
    static scaffold = true
    static menuItem = "Tasks"
}
