package com.webapp

import grails.plugin.springsecurity.SpringSecurityUtils

class LogoutController {

	def index = {
		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
	}
}
