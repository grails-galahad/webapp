package com.webapp

class HomeController {

	def springSecurityService

	def index = {
		if (springSecurityService.isLoggedIn()) {
			redirect controller:"project"
		} else {
			render view:"index"
		}
	}
}
