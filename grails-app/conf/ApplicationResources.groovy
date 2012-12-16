modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery', 'bootstrap'
        resource url: 'css/scaffolding.css'
        resource url:'js/application.js'
        resource url:'less/application.less', attrs:[rel: "stylesheet/less", type:'css'], bundle:'monolith'
        resource url: 'css/dummy.css'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
    }
}
