import grails.util.Environment
import com.asual.lesscss.LessEngine

def origResourcesFile

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
