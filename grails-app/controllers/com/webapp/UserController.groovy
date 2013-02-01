package com.webapp

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class UserController {
	static scaffold = true
	static menuItem = "Users"
}
