grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.source.level = 1.7
grails.project.target.level = 1.7

grails.project.fork = [
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven"
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
        mavenLocal()
        grailsCentral()
        mavenCentral()
		mavenRepo "http://repo.spring.io/milestone/"
    }

    dependencies {
		compile "com.asual.lesscss:lesscss-engine:1.4.2"
        runtime "postgresql:postgresql:9.1-901.jdbc4"
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
			exclude "xml-apis"
		}
		test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
		test "org.gebish:geb-spock:0.9.2"
    }

    plugins {
		build ":tomcat:7.0.52.1"
		
        compile ":scaffolding:2.0.2"
        compile ':cache:1.1.1'
        compile ":fields:1.3"
        compile ":spring-security-core:2.0-RC2"
        compile(":heroku:1.0.1") {
            exclude 'database-session'
        }
        compile(":cookie-session:2.0.13")
        compile ":console:1.3"
        compile ":mail:1.0.1"
        compile ":quartz:1.0.1"

        runtime ":hibernate:3.6.10.10"
        runtime ":database-migration:1.3.8"
        runtime ":jquery:1.11.0.2"
		runtime ":jquery-ui:1.10.3"
        runtime ":resources:1.2.7"
        runtime ":cache-headers:1.1.5"
        runtime ":cached-resources:1.1"
        runtime ":zipped-resources:1.0.1"
        
		test ":geb:0.9.2"
    }
}
