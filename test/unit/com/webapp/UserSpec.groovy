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
        user.errors.hasFieldErrors 'username'
        user.errors.hasFieldErrors 'password'
        user.errors.hasFieldErrors 'fullName'
    }
    
    def "validate user with empty address"() {
        given:
        def user = new User(username:'ronb', password:'asdf', fullName:'Ron Burgundy', address:new Address())
        
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
         def user = new User(username:'ronb', password:'asdf', fullName:'Ron Burgundy', address:new Address(
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