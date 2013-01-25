package com.webapp

class Task {
    
    String desc
    Date due
    Boolean complete = false
    Date dateCreated
    Date lastUpdated
    
    static belongsTo = [project:Project]

    static constraints = {
        desc blank:false
        due nullable:true
    }
    
    static views = [
	    list: [includes:['desc', 'due']],
	    show: [excludes:['lastUpdated']],
	    create: [excludes:['complete', 'dateCreated', 'lastUpdated']],
	    edit: [excludes:['dateCreated', 'lastUpdated']]
	]
	
	String toString() { desc }
}
