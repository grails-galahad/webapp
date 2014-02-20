import com.asual.lesscss.LessEngine

includeTargets << grailsScript("_GrailsInit")

target(main: "Recompiles application.less into application.css.") {
	def compiler = new LessEngine()
	File input = new File("${basedir}/web-app/less/application.less")
	File target = new File("${basedir}/web-app/css/application.css")
	compiler.compile input, target
}

setDefaultTarget(main)
