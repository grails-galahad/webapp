import grails.util.Environment

grails.app.context = '/'
grails.project.groupId = "com.$appName"
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]
grails.controllers.defaultScope = 'singleton'
grails.databinding.dateFormats = ['MM/dd/yyyy hh:mm a', 'MM/dd/yyyy']
grails.converters.encoding = "UTF-8"
grails.scaffolding.templates.domainSuffix = 'Instance'
grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart=false
grails.exceptionresolver.params.exclude = ['password']
grails.views.default.codec = "html"
grails.gorm.default.mapping = { sort 'id' }

grails {
	hibernate {
		cache.queries = false
		pass.readonly = false
		osiv.readonly = false
	}
	resources {
		adhoc {
			patterns = []
			includes = [] 
			excludes = ["*"]
		}
		mappers {
			lesscss.compress = true
			cssrewriter.excludes = ['**/boostrap/fonts/**']
			csspreprocessor.excludes = ['**/bootstrap/fonts/**']
		}
	}
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml'
            codecs {
                expression = 'html'
                scriptlet = 'none'
                taglib = 'none'
                staticparts = 'none'
            }
        }
    }
    plugin {
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
			rejectIfNoRule = false
			fii.rejectPublicInvocations = false
			logout.postOnly = false
			useSessionFixationPrevention = false
            controllerAnnotations.staticRules = [
				"/console/**": 					  ["ROLE_ADMIN"],
				"/dbconsole/**": 				  ["ROLE_ADMIN"]
			]
            secureChannel.definition = [
				'/registration/**': 			  'REQUIRES_SECURE_CHANNEL',
				'/login/**': 					  'REQUIRES_SECURE_CHANNEL',
				'/project/**': 					  'REQUIRES_SECURE_CHANNEL',
				'/task/**': 					  'REQUIRES_SECURE_CHANNEL',
				'/user/**': 					  'REQUIRES_SECURE_CHANNEL',
				'/console/**': 					  'REQUIRES_SECURE_CHANNEL',
				'/dbconsole/**': 				  'REQUIRES_SECURE_CHANNEL'
            ]
        }
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
	mail {
		host = "smtp.mandrillapp.com"
		port = 587
		username = "paulcitarella"
		password = "JEg-I9BapHcYLT8gKesUiw"
	}
	mail.default.from = "info@${appName}.com"
}

if (!(Environment.current in [Environment.DEVELOPMENT, Environment.TEST])) {
    grails.plugin.springsecurity.portMapper.httpPort = 80
    grails.plugin.springsecurity.portMapper.httpsPort = 443
    grails.plugin.springsecurity.secureChannel.useHeaderCheckChannelSecurity = true
    grails.logging.jul.usebridge = false
    grails.plugin.databasemigration.updateOnStart = true
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
