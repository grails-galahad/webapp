package com.webapp

class ErrorController {
    
    def index() {
        throw new RuntimeException("Intentional error!")
    }
}
