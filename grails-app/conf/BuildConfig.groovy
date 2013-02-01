grails.servlet.version = "2.5"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.source.level = 1.6
grails.project.target.level = 1.6

grails.project.dependency.resolution = {
	
    inherits "global"
    log "error"
    checksums true
    legacyResolve false

    repositories {
        inherits true
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
		runtime ":jquery:1.8.3"
        runtime ":resources:1.1.6"
        runtime ":database-migration:1.3.2"
		// runtime ":cache-headers:1.1.5"
		// runtime ":cached-resources:1.0"
		// runtime ":zipped-resources:1.0"
		
        build ":tomcat:$grailsVersion"
		
		compile ':cache:1.0.1'
		compile ":lesscss-resources:1.3.0.3"
        compile ":fields:1.3"
        compile ":spring-security-core:1.2.7.3"
        
        test(":spock:0.7") {
            exclude "spock-grails-support"
        }
    }
}
