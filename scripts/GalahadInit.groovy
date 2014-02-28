includeTargets << grailsScript("_GrailsInit")

target(main: "Renames a Galahad webapp application and refactors package structure accordingly.") {
    if (!args) {
        println "Usage: grails galahad-init [new_app_name]"
        fail(message:"New app name was not specified")
    }
    
    def base = basedir
    def appName = args.split()[0]
    def excludes = ['Readme.md', 'GalahadInit.groovy']
    
    ant.delete dir:"${base}/target"
    
    def renameList = []
    new File("${base}").eachDirRecurse { d ->
        if (d.directory && !d.hidden && !d.path.contains('/.') && d.name == "webapp") renameList << d.path
    }
    
    renameList.each { path ->
        def d = new File(path)
        def newPath = d.path.replace('webapp', appName)
        if (d.renameTo(new File(newPath))) {
            println "Renamed ${d.path} -> ${newPath}"
        } else {
            println "Failed to rename ${d.path} -> ${newPath}"
        }
    }
    
    new File("${base}").eachFileRecurse { f ->
        if (f.file && !f.hidden && !f.path.contains('/.') && !(f.name in excludes)) {
            def contents = f.text
            if (contents =~ /webapp/) {
                f.text = contents.replaceAll('webapp', appName)
                println "Updated ${f.path}"
            }
        }
    }
    
}

setDefaultTarget(main)
