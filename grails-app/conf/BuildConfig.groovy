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
    
    def seleniumVersion = "2.27.0"

    repositories {
        inherits true
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        runtime "postgresql:postgresql:9.1-901.jdbc4"
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
			exclude "xml-apis"
		}
		test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
        test "org.gebish:geb-spock:0.9.0-RC-3"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
		runtime ":jquery:1.8.3"
		runtime ":jquery-ui:1.8.24"
        runtime ":resources:1.2.RC2"
        runtime ":database-migration:1.3.2"
        runtime ":cache-headers:1.1.5"
        runtime ":cached-resources:1.0"
        runtime ":zipped-resources:1.0"
		
        build ":tomcat:$grailsVersion"
		
		compile ":cache:1.0.1"
		compile ":lesscss-resources:1.3.3"
        compile ":fields:1.3"
        compile ":spring-security-core:1.2.7.3"
        compile(":heroku:1.0.1") {
            exclude 'database-session'
        }
        compile(":cookie-session:2.0.7") {
            exclude 'asm'
        }
        compile ":console:1.2"
        compile ":mail:1.0.1"
        compile ":quartz:1.0-RC5"
        
        test(":spock:0.7") {
            exclude "spock-grails-support"
        }
        test ":geb:0.9.0-RC-3"
    }
}
