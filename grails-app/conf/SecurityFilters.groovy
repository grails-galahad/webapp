import org.springframework.util.AntPathMatcher

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
        def secureDefs = grailsApplication.config.grails.plugin.springsecurity.secureChannel.definition
        
        if (secureDefs) {
            def securePaths = secureDefs.findAll { it.value == 'REQUIRES_SECURE_CHANNEL' }.collect { it.key }
            def pathMatcher = new AntPathMatcher()
            securePaths.each { path ->
                if (pathMatcher.match(path, url)) return true
            }
        }
    }
    
    private String convertToHttps(String url) {
        def httpPort = grailsApplication.config.grails.plugin.springsecurity.portMapper.httpPort ?: 8080
        def httpsPort = grailsApplication.config.grails.plugin.springsecurity.portMapper.httpsPort ?: 8443
        url.replace('http://', 'https://').replace(":${httpPort}", ":${httpsPort}")
    }
}
