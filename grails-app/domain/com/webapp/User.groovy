package com.webapp

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	String fullName
	String email
	Date dateOfBirth
	Address address
	
	static embedded = ["address"]

	static constraints = {
		fullName blank: false
		username blank: false, unique: true
		password blank: false
		email blank: false, email: true
		dateOfBirth nullable: true
		address nullable: true
	}

	static mapping = {
	    table "people"
		password column: '`password`'
	}
	
	static views = [
	    list: [includes:['fullName', 'email', 'address']],
	    show: [excludes:['password', 'enabled', 'accountExpired', 'accountLocked', 'passwordExpired']],
	    create: [excludes:['enabled', 'accountExpired', 'accountLocked', 'passwordExpired']],
	    edit: [excludes:['password', 'enabled', 'accountExpired', 'accountLocked', 'passwordExpired']]
	]

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
	
	String toString() { fullName }
}
