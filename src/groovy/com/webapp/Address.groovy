package com.webapp

class Address {

	String address1
	String address2
	String city
	String state
	String postalCode
	
	static constraints = {
	    address1 blank:false
	    address2 nullable:true
	    city blank:false
	    state blank:false
	    postalCode blank:false
    }
	
	@Override
	String toString() {
		[address1, address2, city, state, postalCode].findAll { it }.join(', ')
	}

}
