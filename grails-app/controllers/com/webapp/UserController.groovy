package com.webapp

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class UserController {
	static scaffold = true
	static menuItem = "Users"
}
