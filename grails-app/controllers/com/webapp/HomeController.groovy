package com.webapp

class HomeController {

	def index() {
		if (isLoggedIn()) {
			redirect controller:"project"
		} else {
			render view:"index"
		}
	}
}
