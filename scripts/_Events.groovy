import grails.util.Environment
import org.lesscss.LessCompiler

def origResourcesFile

eventCompileStart = {
    if (!(grailsEnv in ['development', 'test'])) {
        event("LessPrecompileStart", [])
        event("StatusUpdate", ["Compiling application.less into application.css"])
        
        def compiler = new LessCompiler()
        File input = new File("${basedir}/web-app/less/application.less")
        File target = new File("${basedir}/web-app/css/application.css")
        try {
            compiler.compile input, target
        } catch (ex) {
            event("StatusError", ["Less precompile failed"])
            ex.printStackTrace()
        }
        
        origResourcesFile = File.createTempFile("res", "groovy")
        ant.copy file: "${basedir}/grails-app/conf/ApplicationResources.groovy", tofile: origResourcesFile.path, overwrite: true
        ant.replaceregexp file: "${basedir}/grails-app/conf/ApplicationResources.groovy",
                          match: "less/application.less",
                          replace: "css/application.css",
                          flags: "g"
        
        event("LessPrecompileEnd", [])
    }
}

eventCreateWarEnd = { warName, stagingDir ->
    if (!(grailsEnv in ['development', 'test'])) {
        ant.copy file: origResourcesFile.path, tofile: "${basedir}/grails-app/conf/ApplicationResources.groovy", overwrite: true
        ant.delete file: "${basedir}/web-app/css/application.css"
    }
}
