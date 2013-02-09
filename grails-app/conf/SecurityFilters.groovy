import org.springframework.security.web.util.AntUrlPathMatcher

class SecurityFilters {
    
    def grailsApplication
    
    def filters = {
        enforceSsl(controller: '*', action: '*') {
            after = {
                String loc = response.getHeader("Location")
                if (loc && requiresHttps(loc)) {
                    response.setHeader("Location", convertToHttps(loc))
                }
            }
        }
    }
    
    private boolean requiresHttps(String url) {
        def secureDefs = grailsApplication.config.grails.plugins.springsecurity.secureChannel.definition
        
        if (secureDefs) {
            def securePaths = secureDefs.findAll { it.value == 'REQUIRES_SECURE_CHANNEL' }.collect { it.key }
            securePaths.each { path ->
                def urlMatcher = new AntUrlPathMatcher(true)
                if (urlMatcher.pathMatchesUrl(path, url)) return true
            }
        }
    }
    
    private String convertToHttps(String url) {
        def httpPort = grailsApplication.config.grails.plugins.springsecurity.portMapper.httpPort ?: 8080
        def httpsPort = grailsApplication.config.grails.plugins.springsecurity.portMapper.httpsPort ?: 8443
        url.replace('http://', 'https://').replace(":${httpPort}", ":${httpsPort}")
    }
}