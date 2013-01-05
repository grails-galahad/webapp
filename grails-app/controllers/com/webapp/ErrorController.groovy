package com.webapp

class ErrorController {

	def index() {
		throw new RuntimeException("Deliberate error!")
	}
	
}
