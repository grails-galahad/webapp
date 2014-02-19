#!/usr/bin/env groovy

@Grab(group='com.asual.lesscss', module='lesscss-engine', version='1.4.2')
import com.asual.lesscss.LessEngine

def compiler = new LessEngine()
File input = new File("../web-app/less/application.less")
File target = new File("../web-app/css/application.css")
compiler.compile input, target
