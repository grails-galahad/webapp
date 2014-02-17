package com.webapp

class Task {
    
    String descr
    Date due
    Boolean complete = false
    Date dateCreated
    Date lastUpdated
    
    static belongsTo = [project:Project]

    static constraints = {
        descr blank:false
        due nullable:true
    }
	
    static views = [
	    list: [includes:['descr', 'due']],
	    show: [excludes:['lastUpdated']],
	    create: [excludes:['complete', 'dateCreated', 'lastUpdated']],
	    edit: [excludes:['dateCreated', 'lastUpdated']]
	]
	
	String toString() { descr }
}
