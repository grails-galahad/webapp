package com.webapp

class Project {
    
    String name
    User owner
    Date dateCreated
    Date lastUpdated
    
    static hasMany = [tasks:Task]

    static constraints = {
        name blank:false
    }
	
	static mapping = {
		tasks sort:'id'
	}
	
    static views = [
	    list: [includes:['name', 'owner']],
	    show: [excludes:['lastUpdated']],
	    create: [excludes:['tasks', 'dateCreated', 'lastUpdated']],
	    edit: [excludes:['dateCreated', 'lastUpdated']]
	]
	
	String toString() { name }
}
