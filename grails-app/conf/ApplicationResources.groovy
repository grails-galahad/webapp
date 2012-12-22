modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, bootstrap-js'
        resource url: 'js/application.js'
        resource url: 'less/application.less', attrs:[rel: "stylesheet/less", type:'css'], disposition: 'head'
        resource url: 'css/scaffolding.css'
        resource url: 'css/dummy.css'
        resource url: 'bootstrap/img/glyphicons-halflings-white.png'
        resource url: 'bootstrap/img/glyphicons-halflings.png'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
    }
}
