modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, bootstrap-js'
        resource url: 'js/application.js'
        resource url: 'js/bootstrap-datepicker.js'
        resource url: 'css/scaffolding.css'
        resource url: 'less/application.less'
        resource url: 'css/dummy.css'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
    }
}
