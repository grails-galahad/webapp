package com.webapp

class Task {
    
    String desc
    Date due
    Boolean complete = false
    
    Date dateCreated
    Date lastUpdated

    static constraints = {
        desc blank:false
        due nullable:true
    }
    
    static views = [
	    list: [includes:['desc', 'due']],
	    show: [excludes:['lastUpdated']],
	    create: [includes:['desc', 'due']],
	    edit: [excludes:['dateCreated', 'lastUpdated']]
	]
}
