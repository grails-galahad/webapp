modules = {
    application {
        defaultBundle 'monolith'
        dependsOn 'jquery, jquery-ui, bootstrap-js'
        resource url: 'js/application.js'
        resource url: 'js/bootstrap-datepicker.js'
        resource url: 'less/application.less'
        resource url: 'css/dummy.css'
    }

    overrides {
        jquery {
            defaultBundle 'monolith'
        }
        'jquery-ui' {
            defaultBundle 'monolith'
        }
    }
}
