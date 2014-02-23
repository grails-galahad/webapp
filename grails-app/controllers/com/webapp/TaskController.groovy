package com.webapp

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(['ROLE_USER','ROLE_ADMIN'])
@Transactional(readOnly = true)
class TaskController {
    static scaffold = true
    static menuItem = "Tasks"
}
