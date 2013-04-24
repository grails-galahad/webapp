import grails.util.Environment

grails.app.context = '/'
grails.project.groupId = "com.$appName"
grails.mime.file.extensions = true
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.views.default.codec = "none"
grails.views.gsp.encoding = "UTF-8"
grails.views.gsp.sitemesh.preprocess = true
grails.converters.encoding = "UTF-8"
grails.scaffolding.templates.domainSuffix = 'Instance'
grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart=false
grails.exceptionresolver.params.exclude = ['password']
grails.hibernate.cache.queries = false

grails {
    plugins {
        springsecurity {
            userLookup {
                userDomainClassName = 'com.webapp.User'
                usernamePropertyName = 'email'
                authorityJoinClassName = 'com.webapp.UserRole'
            }
            authority.className = 'com.webapp.Role'
            rememberMe {
                cookieName = 'webapp_remember_me'
                key = 'webapp'
            }
            controllerAnnotations.staticRules = [
			   "/console/**": ["ROLE_ADMIN"],
			   "/dbconsole/**": ["ROLE_ADMIN"]
			]
            secureChannel.definition = [
               '/registration/**': 'REQUIRES_SECURE_CHANNEL',
               '/login/**': 'REQUIRES_SECURE_CHANNEL',
               '/project/**': 'REQUIRES_SECURE_CHANNEL',
               '/task/**': 'REQUIRES_SECURE_CHANNEL',
               '/user/**': 'REQUIRES_SECURE_CHANNEL',
               '/console/**': 'REQUIRES_SECURE_CHANNEL',
               '/dbconsole/**': 'REQUIRES_SECURE_CHANNEL'
            ]
        }
    }
    plugin {
        databasemigration {
            updateOnStartFileNames = ['changelog.groovy']
            dbDocController.enabled = false
        }
        cookiesession {
            enabled = true
            springsecuritycompatibility = true
            secret = "webappwebapp"
            sessiontimeout = 30*60
            cookiename = 'webapp_session'
            maxcookiesize = 2048
            cookiecount = 5
        }
    }
}

grails {
   mail {
     host = "smtp.mandrillapp.com"
     port = 587
     username = "paulcitarella"
     password = "JEg-I9BapHcYLT8gKesUiw"
   }
   mail.default.from = "info@enterprise-grails.com"
}

if (!(Environment.current in [Environment.DEVELOPMENT, Environment.TEST])) {
        grails.plugins.springsecurity.portMapper.httpPort = 80
        grails.plugins.springsecurity.portMapper.httpsPort = 443
        grails.plugins.springsecurity.secureChannel.useHeaderCheckChannelSecurity = true
        grails.logging.jul.usebridge = false
        grails.plugin.databasemigration.updateOnStart = true
        grails.dbconsole.enabled = true
}

environments {
    development {
        grails.logging.jul.usebridge = true
        grails.mail.disabled = true
        // grails.mail.overrideAddress = "test@address.com"
    }
    test {
        grails.logging.jul.usebridge = true
        grails.mail.disabled = true
    }
    stage {
    }
    production {
    }
}

log4j = {
    appenders {
       'null' name:"stacktrace"
    }
}
