package com.webapp

import grails.test.mixin.*
import grails.test.mixin.support.*
import spock.lang.Specification

@TestFor(User)
class UserSpec extends Specification {

    def "validate empty user"() {
        given:
        def user = new User()
        
        when:
        user.validate()
        
        then:
        user.errors.errorCount == 3
        user.errors.hasFieldErrors 'fullName'
        user.errors.hasFieldErrors 'password'
        user.errors.hasFieldErrors 'email'
    }
    
    def "validate user with empty address"() {
        given:
        def user = new User(password:'asdf', fullName:'Ron Burgundy', email:'ronb@kvwn.net', address:new Address())
        
        when:
        user.validate()
        
        then:
        user.errors.errorCount == 4
        user.errors.hasFieldErrors 'address.address1'
        user.errors.hasFieldErrors 'address.city'
        user.errors.hasFieldErrors 'address.state'
        user.errors.hasFieldErrors 'address.postalCode'
    }
    
    def "validate a valid user"() {
        given:
         def user = new User(password:'asdf', fullName:'Ron Burgundy', email:'ronb@kvwn.net', address:new Address(
                address1: '123 Street Rd.',
                city: 'San Diego',
                state: 'CA',
                postalCode: '92101'
                ))
        
        when:
        user.validate()
        
        then:
        user.hasErrors() == false
    }
}
