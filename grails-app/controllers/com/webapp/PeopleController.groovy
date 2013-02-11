package com.webapp

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER','ROLE_ADMIN'])
class PeopleController {
	static scaffold = User
	static menuItem = "People"
}
