modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, bootstrap-js'
        resource url: 'js/application.js'
        resource url: 'css/scaffolding.css'
        resource url: 'less/application.less', attrs:[rel: "stylesheet/less", type:'css'], disposition: 'head'
        resource url: 'css/dummy.css'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
    }
}
