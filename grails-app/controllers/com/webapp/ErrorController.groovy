package com.webapp

import grails.transaction.Transactional

@Transactional(readOnly = true)
class ErrorController {
    
    def index() {
        throw new RuntimeException("Intentional error!")
    }
}
