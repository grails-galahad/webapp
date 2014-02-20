import grails.util.Environment
import com.asual.lesscss.LessEngine

def origResourcesFile

/*
 * Less pre-compilation is required because the lesscss-resources plugin hasn't upgraded past Less 1.3.3
 * and can't compile Bootstrap 3. This step uses Less Engine, which supports Less 1.4.2.
*/
eventCompileStart = {
    event("LessPrecompileStart", [])
    event("StatusUpdate", ["Compiling application.less into application.css"])
    
    def compiler = new LessEngine()
    File input = new File("${basedir}/web-app/less/application.less")
    File target = new File("${basedir}/web-app/css/application.css")
    try {
        compiler.compile input, target
    } catch (ex) {
        event("StatusError", ["Less precompile failed"])
        ex.printStackTrace()
    }
    
    event("LessPrecompileEnd", [])
}
